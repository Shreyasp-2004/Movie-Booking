package com.shreyas.book_My_Show.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreyas.book_My_Show.entity.ProfileEntity;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity,Long>{
Optional<ProfileEntity> findByEmail(String email);
}
