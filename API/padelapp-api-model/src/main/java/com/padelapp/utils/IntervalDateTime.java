package com.padelapp.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntervalDateTime {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private static final Logger logger = LoggerFactory.getLogger(IntervalDateTime.class);
    public boolean overlaps(IntervalDateTime other) {
        logger.info("fecha de la clase " +this.startDateTime + " " +this.endDateTime+ " " +other);
        return !(this.startDateTime.isAfter(other.endDateTime) || this.endDateTime.isBefore(other.startDateTime));
    }
}
