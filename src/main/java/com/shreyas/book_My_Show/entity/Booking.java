package com.shreyas.book_My_Show.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User who made the booking
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Show for which booking is made
    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    // Booking time
    private LocalDateTime bookingTime;

    // List of seats booked (many-to-many)
    @ManyToMany
    @JoinTable(
        name = "booking_seats",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;

    // Total price for the booking
    private Double totalPrice;

    // Booking status: e.g., CONFIRMED, CANCELLED, PENDING
    // @Enumerated(EnumType.STRING)
    // private BookingStatus status;
}


