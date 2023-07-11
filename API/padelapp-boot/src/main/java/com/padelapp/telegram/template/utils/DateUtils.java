package com.padelapp.telegram.template.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public enum DayDescription {
        TODAY("HOY"),
        TOMORROW("MAÑANA"),
        MONDAY("LUNES"),
        TUESDAY("MARTES"),
        WEDNESDAY("MIÉRCOLES"),
        THURSDAY("JUEVES"),
        FRIDAY("VIERNES"),
        SATURDAY("SÁBADO"),
        SUNDAY("DOMINGO");

        private final String description;

        private DayDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        LocalDate currentDate = LocalDate.now();
        LocalDate tomorrowDate = currentDate.plusDays(1);


        DayDescription dayDescription = DayDescription.valueOf(dateTime.getDayOfWeek().toString());
        StringBuilder sb = new StringBuilder();
        if (dateTime.toLocalDate().isEqual(currentDate)) {
            sb.append(DayDescription.TODAY.getDescription()).append(", ");
        } else if (dateTime.toLocalDate().isEqual(tomorrowDate)) {
            sb.append(DayDescription.TOMORROW.getDescription()).append(", ");
        }
        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd"));
        sb.append(dayDescription.getDescription()).append(" ").append(formattedDate);

        return sb.toString();
    }


}

