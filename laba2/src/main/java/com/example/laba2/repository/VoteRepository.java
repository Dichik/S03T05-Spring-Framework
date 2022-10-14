package com.example.laba2.repository;

import com.example.laba2.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUserIdAndPetitionId(Long userId, Long petitionId);

    Long countByPetitionId(Long petitionId); // TODO rewrite that

}
