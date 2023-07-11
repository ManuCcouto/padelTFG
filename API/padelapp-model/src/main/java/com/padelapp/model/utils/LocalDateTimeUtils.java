package com.padelapp.model.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class LocalDateTimeUtils {

  private static final String WITHOUT_TIME_ZONE_REGEX = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?$";

  public ZonedDateTime offsetDateTimeNow(final ZoneOffset zoneOffset) {
    return OffsetDateTime.now().atZoneSameInstant(zoneOffset);
  }

  public LocalDateTime now(final ZoneOffset zoneOffset) {
    return Objects.isNull(zoneOffset) ? LocalDateTime.now() : LocalDateTime.now(zoneOffset);
  }

  public LocalDateTime ofInstant() {
    return this.ofInstant(null, null);
  }

  public LocalDateTime ofInstant(final Instant instant, final ZoneOffset zoneOffset) {
    return OffsetDateTime
        .ofInstant(instant != null ? instant : Instant.now(), zoneOffset != null ? zoneOffset : ZoneOffset.UTC)
        .toLocalDateTime();
  }

  public LocalDateTime ofInstant(final Instant instant, final ZoneId zoneId) {
    return OffsetDateTime
        .ofInstant(instant != null ? instant : Instant.now(), zoneId != null ? zoneId : ZoneOffset.UTC)
        .toLocalDateTime();
  }

  public long uniqueCurrentTimeMS(final AtomicLong referenceAtomicLong) {
    long now = this.currentTimeMillis();
    while (true) {
      final long lastTime = referenceAtomicLong.get();
      if (lastTime >= now) {
        now = lastTime + 1;
      }
      if (referenceAtomicLong.compareAndSet(lastTime, now)) {
        return now;
      }
    }
  }

  public GregorianCalendar newUniqueCalendar(final boolean zulu, final AtomicLong referenceAtomicLong) {
    final GregorianCalendar calendar = new GregorianCalendar();
    if (zulu) {
      calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    calendar.setTimeInMillis(this.uniqueCurrentTimeMS(referenceAtomicLong));
    return calendar;
  }

  public String completeDateTimeTimeZone(final String dateTime) {
    if (dateTime == null) {
      return null;
    }
    String result = dateTime;
    // fix para tratar como UTC las fechas que no indiquen timeZone
    if (result.matches(WITHOUT_TIME_ZONE_REGEX)) {
      result += "Z";
    }
    return result;
  }

  public long currentTimeMillis() {
    return System.currentTimeMillis();
  }

}
