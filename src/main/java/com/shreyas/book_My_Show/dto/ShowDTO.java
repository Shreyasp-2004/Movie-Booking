package com.shreyas.book_My_Show.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowDTO {
    private Long id;
    private String showTime; // string format for API (e.g. "2025-08-16T19:30")
    private double ticketPrice;
    private Long movieId;
    private Long screenId;
}
