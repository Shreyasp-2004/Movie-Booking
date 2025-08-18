package com.shreyas.book_My_Show.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private ProfileEntity user;   // ✅ Registered user who booked

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private ShowEntity show;      // ✅ Show booked

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private SeatEntity seat;      // ✅ Seat booked

    private Double totalPrice;

    private String bookingStatus;  // e.g. CONFIRMED, CANCELLED

}
