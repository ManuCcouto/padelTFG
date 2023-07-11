package com.padelapp.entities;


import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "TIME_SLOT")
public class TimeSlot {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_TIME_SLOT")
        private int idTimeSlot;

        private LocalDateTime startTimeSlot;

        private LocalDateTime endTimeSlot;

        private String days;

        private int incrementPrice;
}
