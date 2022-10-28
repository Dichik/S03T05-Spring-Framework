package com.example.laba2.repository;

import com.example.laba2.entity.PetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetitionRepository extends JpaRepository<PetitionEntity, Long> {
}
