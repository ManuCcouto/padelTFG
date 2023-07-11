package com.padelapp.dao;

import com.padelapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public interface BookingDao {


    boolean checkBooking(LocalDateTime startDate ,LocalDateTime endDate, Integer Resource);
}
