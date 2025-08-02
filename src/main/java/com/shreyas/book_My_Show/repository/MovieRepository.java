package com.shreyas.book_My_Show.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.book_My_Show.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Custom query methods if needed
}
