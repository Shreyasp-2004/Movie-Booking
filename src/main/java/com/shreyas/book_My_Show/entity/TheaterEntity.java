package com.shreyas.book_My_Show.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEntity {
    private int id;
    private String name; 
    private String city;

}
