package com.padelapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "BILL")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBILL")
    private Long id;

    @Column(name = "TOTALPRICE")
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "TIME_SLOT", referencedColumnName = "ID_TIME_SLOT")
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "PAY_TYPE", referencedColumnName = "ID_PAY")
    private PayType payType;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "booking", referencedColumnName = "booking_bookinid"),
            @JoinColumn(name = "user", referencedColumnName = "USER_iduser")
    })
    private BookingUser bookingUser;
}
