package com.shreyas.book_My_Show.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScreenDTO {
    private Long id;
    private String name;
    private int totalSeats;
    private Long theatreId; // reference to Theatre
}
