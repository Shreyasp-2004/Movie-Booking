package com.shreyas.book_My_Show.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MovieEntity {

    private int id;
    private String name;
    
    
}
