package com.padelapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "RESOURCE_TYPE")
@Data
public class ResourceType {

    @Id
    @Column(name = "ID_RESOURCE_TYPE")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    // other attributes and relationships

    // getters and setters, constructors, and other methods

}