package com.shreyas.book_My_Show.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private Long movieId;
    private String movieName;
    private String movieDescription;
    private int movieDuration;
    private String movieLanguage;
}
