package com.shreyas.book_My_Show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreyas.book_My_Show.entity.ScreenEntity;

@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity,Long> {

}
