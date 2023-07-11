package com.padelapp.telegram.template.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTest {
    LocalDateTime now = LocalDateTime.now();
    @Test
    public void testFormatDateTimeToday() {
        String actual = DateUtils.formatDateTime(now);
        assertTrue(actual.contains(DateUtils.DayDescription.TODAY.getDescription()));
    }

    @Test
    public void testFormatDateTimeTomorrow() {
        LocalDateTime tomorrow = now.plusDays(1);
        String actual = DateUtils.formatDateTime(tomorrow);
        assertTrue(actual.contains(DateUtils.DayDescription.TOMORROW.getDescription()));
    }

    @Test
    public void testFormatDateTimeOtherDay() {
        LocalDateTime otherDay = now.plusDays(2);
        String actual = DateUtils.formatDateTime(otherDay);
        assertFalse(actual.contains(DateUtils.DayDescription.TOMORROW.getDescription()));
        assertFalse(actual.contains(DateUtils.DayDescription.TODAY.getDescription()));
    }
}

