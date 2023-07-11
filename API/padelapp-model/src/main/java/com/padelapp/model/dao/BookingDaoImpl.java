package com.padelapp.model.dao;


import com.padelapp.dao.BookingDao;
import com.padelapp.entities.Booking;
import com.padelapp.entities.BookingUser;
import com.padelapp.entities.User;
import com.padelapp.repository.BookingRepository;
import com.padelapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Repository
public class BookingDaoImpl implements BookingDao {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveBookingWithOwner(Booking booking, User owner) {
        BookingUser bookingUser = new BookingUser(booking, owner, true);
        booking.getBookingUsers().add(bookingUser);
        bookingRepository.save(booking);
    }

    @Override
    public boolean checkBooking(LocalDateTime startDate, LocalDateTime endDate, Integer resource) {
        Optional<Booking> booking = this.bookingRepository.checkBooking(startDate, endDate, resource);
        return !booking.isPresent();

    }
}
