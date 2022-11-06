package com.example.petition.repository;

import com.example.petition.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    Optional<VoteEntity> findByUserIdAndPetitionId(Long userId, Long petitionId);

    List<VoteEntity> findAllByPetitionId(Long petitionId);

}
