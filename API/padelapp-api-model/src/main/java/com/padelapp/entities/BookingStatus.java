package com.padelapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking_status")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_status_gen")
    @SequenceGenerator(name = "booking_status_gen", sequenceName = "booking_status_seq")
    @Column(name = "status_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status_type_id", referencedColumnName = "status_id")
    private StatusType statusType;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @ManyToOne
    @JoinColumn(name = "booking", referencedColumnName = "bookinid")
    private Booking booking;


}
