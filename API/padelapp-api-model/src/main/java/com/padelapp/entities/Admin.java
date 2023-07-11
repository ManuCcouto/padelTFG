package com.padelapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ADMIN")

public class Admin extends User {

    @Column(name = "LEVEL_ADMIN")
    private Integer levelAdmin;

    @Column(name = "DESCRIPTION")
    private String description;

    public Admin() {
        this.getRoles().add(UserRole.ADMIN);
    }
}
