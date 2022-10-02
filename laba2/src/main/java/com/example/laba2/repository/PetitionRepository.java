package com.example.laba2.repository;

import com.example.laba2.entity.Petition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetitionRepository extends CrudRepository<Petition, Long> {
}
