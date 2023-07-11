package com.padelapp.model.service;

import com.padelapp.entities.Booking;
import com.padelapp.entities.BookingUser;
import com.padelapp.repository.BookingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingUserServiceImpl {
    @Autowired
    BookingUserRepository bookingUserRepository;

  public  List<Booking> getBookingsByUSer(Integer userId){
        List<BookingUser> bookingUsers = bookingUserRepository.findByUserId(userId);
        List<Booking> bookings = new ArrayList<>();
        for (BookingUser bookingUser : bookingUsers) {
            bookings.add(bookingUser.getBooking());
        }
      return bookings;
    }
}
