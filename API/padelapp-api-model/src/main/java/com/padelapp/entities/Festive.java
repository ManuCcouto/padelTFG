package com.padelapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "festive")
@Data
public class Festive {

    @Id
    @Column(name = "ID_FESTIVE")
    private int id;

    @Column(name = "DATE")
    private Timestamp date;

    @Column(name = "DESCRIPTION")
    private String description;



}


