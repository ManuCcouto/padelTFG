package com.padelapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "COACH")
public class Coach extends User {

    @Column(name = "SPORT")
    private String sport;
    public Coach() {
        this.getRoles().add(UserRole.MONITOR);
    }
}