package com.padelapp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "booking")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {


        @Id
        @Column(name = "bookinid")
        @GeneratedValue
        private Long id;

        @Column(name = "start_time")
        private LocalDateTime startTime;

        @Column(name = "end_time")
        private LocalDateTime endTime;

        @ManyToOne
        @JoinColumn(name = "BOOKING_TYPE_id_BOOKING_TYPE", referencedColumnName = "id_BOOKING_TYPE", nullable = false)
        private BookingType bookingType;

        @ManyToOne
        @JoinColumn(name = "resource_idresource", referencedColumnName = "idresource", nullable = false)
        private Resource resource;

        @Column(name = "visibility", columnDefinition = "boolean default false")
        private Boolean visibility;

        @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
        private Set<BookingStatus> status= new HashSet<>();


        @Size(max = 4)
        @NotNull
        @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
        private List<BookingUser> bookingUsers = new ArrayList<>();



        @Override
        public String toString() {
                return "Booking{" +
                        "id=" + id +
                        ", startTime=" + startTime +
                        ", endTime=" + endTime +
                        ", bookingType=" + bookingType +
                        ", resource=" + resource +
                        ", bookingUsers=" + bookingUsers +
                        '}';
        }
}




