package com.padelapp.entities;


import com.padelapp.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "status_type")
@NoArgsConstructor
@Data
public class StatusType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_type_gen")
    @SequenceGenerator(name = "status_type_gen", sequenceName = "status_type_seq")
    @Column(name = "status_id", nullable = false)
    private Long id;

    @Column(columnDefinition = "ENUM('CLOSED',    'PREBOOKING',    'CANCELED', 'BLOCKED'")
    @Enumerated(STRING)
    private StatusEnum status;


}
