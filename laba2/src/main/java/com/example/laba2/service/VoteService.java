package com.example.laba2.service;

import com.example.laba2.entity.VoteEntity;
import com.example.laba2.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteService implements IVoteService {

    private final VoteRepository voteRepository;

    public VoteEntity vote(Long userId, Long petitionId) {
        VoteEntity vote = new VoteEntity(userId, petitionId);
        if (voteRepository.findByUserIdAndPetitionId(userId, petitionId).isPresent()) {
            System.out.println("Throw corresponded exception");
            return null;
        }
        return this.voteRepository.save(vote); // TODO autoincrement for db
    }

    public List<VoteEntity> getAll() {
        return this.voteRepository.findAll();
    }

    public VoteEntity getById(Long id) {
        // TODO check if exist
        Optional<VoteEntity> vote = this.voteRepository.findById(id);
        // TODO throw corresponded error
        return vote.orElse(null);
    }

    @Override
    public Long getNumberOfVotesByPetitionId(Long petitionId) {
        return this.voteRepository.countByPetitionId(petitionId);
    }

}
