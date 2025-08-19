package com.shreyas.book_My_Show.dto;

import com.shreyas.book_My_Show.entity.ProfileEntity;
import com.shreyas.book_My_Show.entity.SeatEntity;
import com.shreyas.book_My_Show.entity.ShowEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDTO {
    private Long id;
    private ProfileEntity user;   
    private ShowEntity show;      
    private SeatEntity seat;      
    private Double totalPrice;
    private String bookingStatus; 
}
