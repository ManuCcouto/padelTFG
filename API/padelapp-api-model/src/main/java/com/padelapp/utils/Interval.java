package com.padelapp.utils;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
@AllArgsConstructor
public class Interval {
    private  LocalTime startTime;
    private  LocalTime endTime;


    public IntervalDateTime toIntervalDateTime(LocalDate date) {
        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);
        if (startTime.equals(LocalTime.MIDNIGHT)) endDateTime.plusDays(1L);

        return new IntervalDateTime(startDateTime, endDateTime);
    }

}

