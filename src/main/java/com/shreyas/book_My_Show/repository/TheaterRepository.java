package com.shreyas.book_My_Show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreyas.book_My_Show.entity.TheaterEntity;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity,Long> {

}
