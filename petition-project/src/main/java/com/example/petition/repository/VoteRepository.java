package com.example.petition.repository;

import com.example.petition.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    Optional<VoteEntity> findByUserIdAndPetitionId(Long userId, Long petitionId);

    Long countByPetitionId(Long petitionId); // TODO rewrite that

}
