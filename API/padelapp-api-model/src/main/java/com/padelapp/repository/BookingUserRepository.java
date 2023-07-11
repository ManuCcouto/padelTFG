package com.padelapp.repository;


import com.padelapp.entities.Booking;
import com.padelapp.entities.BookingUser;
import com.padelapp.entities.BookingUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingUserRepository extends JpaRepository<BookingUser, BookingUserId> {

        @Query("SELECT bu.booking FROM BookingUser bu WHERE bu.user.id = :userId AND bu.owner = true")
        List<Booking> findAllBookingsByOwnerId(@Param("userId") Integer ownerId);


        @Query("SELECT bu.booking FROM BookingUser bu")
        List<Booking> findAllBookings();

        List<BookingUser> findByUserId(Integer userId);
}
