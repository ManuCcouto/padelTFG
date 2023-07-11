package com.padelapp.dao;

import com.padelapp.entities.TimeSlot;

import java.util.List;

public interface TimeSlotDao {

    List<TimeSlot> findAllTimeSlot();

    TimeSlot findTimeSlotByColor();


}
