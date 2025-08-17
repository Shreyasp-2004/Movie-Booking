package com.shreyas.book_My_Show.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreyas.book_My_Show.entity.SeatEntity;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity,Long> {
List<SeatEntity> findByScreen_Id(Long screenId);
}
