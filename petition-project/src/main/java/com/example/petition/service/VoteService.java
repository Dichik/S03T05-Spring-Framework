package com.example.petition.service;

import com.example.petition.entity.VoteEntity;
import com.example.petition.exception.VoteNotSavedException;
import com.example.petition.repository.VoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class VoteService implements IVoteService {

    private final VoteRepository voteRepository;

    @Override
    public VoteEntity vote(Long userId, Long petitionId) throws VoteNotSavedException {
        VoteEntity vote = this.voteRepository.findByUserIdAndPetitionId(userId, petitionId)
                .orElse(null);
        if (vote == null) {
            String message = String.format("Couldn't save vote of %s user for %s petition", userId, petitionId);
            log.error(message);
            throw new VoteNotSavedException(message);
        }
        log.info(String.format("Saved vote of %s user for %s petition", userId, petitionId));
        return this.voteRepository.save(vote);
    }

    @Override
    public Long getNumberOfVotesByPetitionId(Long petitionId) {
        return this.voteRepository.countByPetitionId(petitionId);
    }

    @Override
    public List<VoteEntity> getByPetitionId(Long petitionId) {
        return this.voteRepository.findAllByPetitionId(petitionId);
    }

}
