package com.padelapp.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "booking_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingUser implements Serializable {

    //@EmbeddedId
    @Id
    @SequenceGenerator(
            name = "booking_user_secuence",
            sequenceName = "booking_user_secuence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "booking_user_secuence")
    @Column(name = "booking_user_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long bookingUserId;

    // private BookingUserId id= new BookingUserId();

    @ManyToOne
    // @MapsId("bookingId")
    @JoinColumn(name = "booking_bookinid", referencedColumnName = "bookinid")
    private Booking booking;

    @ManyToOne
    // @MapsId("userId")
    @JoinColumn(name = "USER_iduser", referencedColumnName = "iduser")
    private User user;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @Column(name = "OWNER")
    private Boolean owner;

    public BookingUser(Booking booking, User owner, Boolean b) {
        this.booking = booking;
        this.user = owner;
        this.owner = b;
    }

    @Override
    public String toString() {
        return "BookingUser{" +
                "id=" + bookingUserId +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookingUser that = (BookingUser) o;
        return getBookingUserId() != null && Objects.equals(getBookingUserId(), that.getBookingUserId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
