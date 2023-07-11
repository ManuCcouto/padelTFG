package com.padelapp.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Entity
@Table(name = "RESOURCE")
@Data
public class Resource {

    @Id
    @Column(name = "idresource")
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "RESOURCE_TYPE_ID_RESOURCE_TYPE")
    private ResourceType resourceType;

    @Column(name = "timeSlot")
    private Integer timeSlot;

    @Column(name = "basePrice")
    private Double basePrice;

    @Column(name = "StartTimeSlot")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTimeSlot;

    @Column(name = "endTimeSlot")
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private LocalTime endTimeSlot;


    @Column(name = "DAY_in_ADVANCE")
    private Integer dayInAdvance;



}
