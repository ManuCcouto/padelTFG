package com.padelapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "MEMBER_CLUB")
public class MemberClub extends User {

    @Column(name = "MEMBER_CLUB_START_TIME")
    private Timestamp startTime;

    @Column(name = "MEMBER_CLUB_END_TIME")
    private Timestamp endTime;

    @Column(name = "DNI")
    private String dni;

    private Boolean onHold;

    public MemberClub() {
        this.getRoles().add(UserRole.MEMBER);
    }
}
