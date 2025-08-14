package com.shreyas.book_My_Show.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Theater")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;
    
    @Column(nullable = false)
    private String theaterName; 

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    private int totalScreens;

}
