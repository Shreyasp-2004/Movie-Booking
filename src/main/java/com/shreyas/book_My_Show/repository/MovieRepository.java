package com.shreyas.book_My_Show.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.book_My_Show.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
    
}
