package com.shreyas.book_My_Show.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="seat")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;  // e.g. "A1", "B10"

    private String seatType;    // e.g. "REGULAR", "PREMIUM", "VIP"
    
    @Builder.Default
    private boolean isAvailable = true; // seat status

    // Many seats belong to one screen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private ScreenEntity screen;

}

