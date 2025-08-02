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
public class Theater {
    @Id
    private Long theaterId;
    private String theaterName;
    private String location;
}
