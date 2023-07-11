package com.padelapp.service;

import com.api.model.BookingDTO;
import com.api.model.InputBookingDTO;
import com.padelapp.entities.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public interface BookingService {
     List<Booking> getAllBookingsByOwnerId(Integer ownerId);

     List<BookingDTO> findAvailableBookingsBetweenDates(LocalDateTime starDate, LocalDateTime endDate);

     BookingDTO saveNewBooking(InputBookingDTO inputBooking);
}
