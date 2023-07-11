package com.padelapp.model.service;


import com.api.model.BookingDTO;
import com.api.model.InputBookingDTO;
import com.padelapp.dao.BookingDao;
import com.padelapp.dao.ResourceDao;
import com.padelapp.entities.*;

import com.padelapp.model.mapper.BookingMapper;
import com.padelapp.repository.BookingRepository;
import com.padelapp.repository.BookingUserRepository;
import com.padelapp.repository.ResourceRepository;
import com.padelapp.repository.UserRepository;
import com.padelapp.service.BookingService;
import com.padelapp.utils.IntervalDateTime;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
@Slf4j
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingUserRepository bookingUserRepository;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private  ResourceRepository resourceRepository;
    @Autowired
    private BookingMapper bookingMapper;
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    public List<Booking> getAllBookingsByOwnerId(Integer ownerId) {
        logger.info("bookingUserRepository.findAllBookings() {}",bookingUserRepository.findAllBookings());
        return bookingUserRepository.findAllBookingsByOwnerId(ownerId);
    }

    @Override
    public List<BookingDTO> findAvailableBookingsBetweenDates(LocalDateTime starDate, LocalDateTime endDate) {
        List<Booking> existingBookings = this.bookingRepository.findBookingsBetweenDates(starDate, endDate);
        logger.info("las reservas entre dos fechas "+ existingBookings);
        List<Booking> availableBookings = new ArrayList<>(); // Lista para almacenar las reservas disponibles
        logger.info("la hora de los recursos "+ LocalDate.from(starDate));
        Map<IntervalDateTime, List<Resource>> availabilityMapWithDateTime = this.resourceDao.mapToIntervalDate(LocalDate.from(starDate), this.resourceDao.findAllResources());



        Map<IntervalDateTime, List<Resource>> intervalDateTimeListMap=this.getResourcesReservedByTime(existingBookings);

        return this.bookingMapper.toBookingDTOList(findAvailableBookings(availabilityMapWithDateTime, intervalDateTimeListMap));
    }

    @Override
    public BookingDTO saveNewBooking(InputBookingDTO inputBooking) {
        boolean checkBooking = this.bookingDao.checkBooking(inputBooking.getStarDate().toLocalDateTime(), inputBooking.getEndDate().toLocalDateTime(), inputBooking.getResource());
        Booking saveBooking = null;
        logger.info("Se puede reservar  " + checkBooking);
        Resource resource = resourceRepository.findById(inputBooking.getResource()).orElse(null);
        User user = userRepository.findById(inputBooking.getUser()).orElse(null);

        logger.info("La reserva que se user " + user);
        BookingType bookingType= BookingType.builder().id(2).code("GAME").description("PADEL").build();
        if (resource != null && user != null && checkBooking) {

            Booking booking = Booking.builder()
                    .startTime(inputBooking.getStarDate().toLocalDateTime())
                    .endTime(inputBooking.getEndDate().toLocalDateTime())
                    .resource(resource)
                    .bookingType(bookingType)
                    .bookingUsers(new ArrayList<>())
                    .build();



            saveBooking = this.bookingRepository.save(booking);
            BookingUser bookingUsers= BookingUser.builder().user(user).booking(saveBooking).owner(true).build();
            logger.info("a ver como viene la lista "+ saveBooking);
            // booking.addBookingUser(bookingUsers);
            saveBooking.getBookingUsers().add(bookingUsers);
            bookingUsers.setBooking(saveBooking);
            logger.info("La reserva que se guarda " + saveBooking);
            this.bookingUserRepository.save(bookingUsers);
            logger.info("La reserva que se guarda despues del save el id "+ saveBooking.getId());


           // this.bookingUserRepository.saveAll(bookingUsers);
           // logger.info("La reserva que se guarda despues del save "+ saveBooking);
        }


        return bookingMapper.toBookingDTO(saveBooking);
    }

    private  Map<IntervalDateTime, List<Resource>> getResourcesReservedByTime(List<Booking> bookings) {
        Map<IntervalDateTime, List<Resource>> reservedResourcesByTime = new HashMap<>();
        for (Booking booking : bookings) {
            IntervalDateTime bookingInterval = new IntervalDateTime(booking.getStartTime(), booking.getEndTime());
            Resource reservedResource = booking.getResource();
            if (reservedResourcesByTime.containsKey(bookingInterval)) {
                reservedResourcesByTime.get(bookingInterval).add(reservedResource);
            } else {
                List<Resource> resourcesList = new ArrayList<>();
                resourcesList.add(reservedResource);
                reservedResourcesByTime.put(bookingInterval, resourcesList);
            }
        }
        return reservedResourcesByTime;
    }

    private List<Booking> findAvailableBookings(Map<IntervalDateTime, List<Resource>> availabilityMapWithDateTime, Map<IntervalDateTime, List<Resource>> reservedResourcesMap) {
        List<Booking> availableBookings = new ArrayList<>();

        for (Map.Entry<IntervalDateTime, List<Resource>> availabilityEntry : availabilityMapWithDateTime.entrySet()) {
            IntervalDateTime interval = availabilityEntry.getKey();
            List<Resource> availableResources = availabilityEntry.getValue();

            List<Resource> reservedResources = reservedResourcesMap.get(interval);
            if (reservedResources == null) {
                reservedResources = new ArrayList<>();
            }

            List<Resource> availableToReserve = new ArrayList<>(availableResources);
            availableToReserve.removeAll(reservedResources);

            if (!availableToReserve.isEmpty()) {
                // There are resources available to reserve in this interval
                for (Resource resource : availableToReserve) {
                    Booking booking = Booking.builder()
                            .startTime(interval.getStartDateTime())
                            .endTime(interval.getEndDateTime())
                            .resource(resource)
                            .build();

                    availableBookings.add(booking);
                }
            }
        }

        return availableBookings;
    }
}