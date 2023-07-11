package com.padelapp.model.service;

import com.padelapp.entities.Booking;
import com.padelapp.entities.Resource;
import com.padelapp.model.dao.ResourceDaoImpl;
import com.padelapp.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDaoImpl resourceDao;
    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);
    public List<Booking> findAvailableBookingsByTimeSlot(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        logger.info("estos son los recursos "+ resourceDao.findAvailableResourcesByTime(startDateTime, endDateTime));
        return this.mapResourcesToBookings(resourceDao.findAvailableResourcesByTime(startDateTime, endDateTime));


    }

    private List<Booking> mapResourcesToBookings(Map<LocalDateTime, List<Resource>> resourcesByTime) {
        return resourcesByTime.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(resource -> {
                            return Booking.builder()
                                    .resource(resource)
                                    .startTime(entry.getKey())
                                    .endTime(entry.getKey().plusMinutes(90))
                                    .build();
                        })
                )
                .collect(Collectors.toList());
    }
}