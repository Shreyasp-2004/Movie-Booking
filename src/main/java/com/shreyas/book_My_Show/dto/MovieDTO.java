package com.shreyas.book_My_Show.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private String releaseDate;
    private String language;
    private String genre;
    private int durationMinutes;
}
