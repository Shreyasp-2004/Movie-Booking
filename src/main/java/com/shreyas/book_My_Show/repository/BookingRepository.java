package com.shreyas.book_My_Show.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.book_My_Show.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

}
