package com.example.laba2.repository;

import com.example.laba2.entity.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

    Optional<Vote> findByUserIdAndPetitionId(Long userId, Long petitionId);

}
