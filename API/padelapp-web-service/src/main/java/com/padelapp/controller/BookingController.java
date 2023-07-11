package com.padelapp.controller;

import com.api.apimodel.BookingApi;
import com.api.model.BookingDTO;
import com.api.model.BookingType;
import com.api.model.InputBookingDTO;
import com.padelapp.entities.Booking;
import com.padelapp.service.BookingService;
import com.padelapp.model.service.BookingUserServiceImpl;
import com.padelapp.service.ResourceService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;



@RestController
@AllArgsConstructor
public class BookingController implements BookingApi {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    ResourceService resourceService;

    @Autowired
    BookingService bookingService;


    BookingUserServiceImpl bookingUserService;


    @Override
    public ResponseEntity<List<BookingDTO>> findBookingByType(List<BookingType> bookingType) {
        return BookingApi.super.findBookingByType(bookingType);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> findBookingsByDates(OffsetDateTime startDate, OffsetDateTime endDate) {
        logger.info( "LAs fechas" + startDate.toLocalDateTime() + " " + endDate.toLocalDateTime());
        List<BookingDTO> bookings = bookingService.findAvailableBookingsBetweenDates(startDate.toLocalDateTime()
                , endDate.toLocalDateTime());
        return  ResponseEntity.ok(bookings);

    }

    @Override
    public ResponseEntity<BookingDTO> getBookingById(Long bookingId) {

        BookingDTO bookingDTO= new BookingDTO();
        bookingDTO.bookingType(BookingType.GAME);
        bookingDTO.endDate(OffsetDateTime.MAX);
       List<BookingDTO> bookings = new ArrayList<>();
     //  bookings= resourceService.findAvailableBookingsByTimeSlot(LocalDateTime.of(2022, 4, 13, 9, 0, 0)
          //      ,LocalDateTime.of(2022, 4, 13, 23, 0, 0));
       /// logger.info( "Las reservas disponibles!" + bookings );

        bookings= bookingService.findAvailableBookingsBetweenDates(LocalDateTime.of(2023, 4, 13, 9, 0, 0)
                ,LocalDateTime.of(2023, 4, 13, 23, 0, 0));

        logger.info( "Las reservas disponibles!" + bookings );

        List<Booking> bookingsUser = new ArrayList<Booking>();



        return  ResponseEntity.ok(bookingDTO);

    }

    @Override
    public ResponseEntity<BookingDTO> addBooking(InputBookingDTO inputBooking) {

        return ResponseEntity.ok( this.bookingService.saveNewBooking(inputBooking));
    }

    @Override
    public ResponseEntity<Void> deleteBooking(Long bookingId) {
        return BookingApi.super.deleteBooking(bookingId);
    }

    @Override
    public ResponseEntity<BookingDTO> updateBooking(Long bookingId, InputBookingDTO inputBooking) {
        return BookingApi.super.updateBooking(bookingId, inputBooking);
    }
}
