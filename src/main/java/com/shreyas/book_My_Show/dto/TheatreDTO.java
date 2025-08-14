package com.shreyas.book_My_Show.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreDTO {

    private Long id;
    private String name;
    private String city;
    private String address;
    private int totalScreens;
    
}


