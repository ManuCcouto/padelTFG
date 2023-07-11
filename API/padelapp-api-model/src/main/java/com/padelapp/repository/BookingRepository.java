package com.padelapp.repository;


import com.padelapp.entities.Booking;
import com.padelapp.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.startTime >= :startDate AND b.endTime <= :endDate")
    List<Booking> findBookingsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT b FROM Booking b JOIN b.bookingUsers bu WHERE bu.user = :user")
    List<Booking> findBookingsByOwner(@Param("user") User user);


    @Query("SELECT b FROM Booking b WHERE b.startTime <= :endDate AND b.endTime >= :startDate AND b.resource.id = :resourceId")
    Optional<Booking> checkBooking(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("resourceId") Integer resource);
}
