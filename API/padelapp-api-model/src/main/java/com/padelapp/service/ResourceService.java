package com.padelapp.service;

import com.padelapp.entities.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface ResourceService {
    List<Booking> findAvailableBookingsByTimeSlot(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
