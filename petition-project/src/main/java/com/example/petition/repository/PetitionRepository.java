package com.example.petition.repository;

import com.example.petition.entity.PetitionEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface PetitionRepository extends JpaRepository<PetitionEntity, Long> {

    Page<PetitionEntity> findAll(Pageable pageable);

}
