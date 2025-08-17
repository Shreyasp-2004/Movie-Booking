package com.shreyas.book_My_Show.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatDTO {
    private Long id;
    private String seatNumber;
    private String seatType;
    @Builder.Default
    private boolean isAvailable=true;
    private Long screenId;
}
