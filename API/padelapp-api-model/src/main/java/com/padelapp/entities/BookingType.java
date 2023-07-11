package com.padelapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "booking_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingType {

    @Id
    @Column(name = "id_BOOKING_TYPE")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;



}