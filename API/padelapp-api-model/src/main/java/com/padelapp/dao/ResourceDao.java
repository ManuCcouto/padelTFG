package com.padelapp.dao;

import com.padelapp.entities.Resource;
import com.padelapp.utils.Interval;
import com.padelapp.utils.IntervalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ResourceDao {
    Map<LocalDateTime, List<Resource>> findAvailableResourcesByTime(LocalDateTime startDateTime, LocalDateTime endDateTime);
    Map<Interval, List<Resource>> findAllResources();
    Map<IntervalDateTime, List<Resource>> mapToIntervalDate(LocalDate date, Map<Interval, List<Resource>> availabilityResources);
}
