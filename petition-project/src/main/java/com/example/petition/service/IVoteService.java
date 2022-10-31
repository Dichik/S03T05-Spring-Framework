package com.example.petition.service;

import com.example.petition.entity.VoteEntity;
import com.example.petition.exception.VoteNotSavedException;

import java.util.List;

public interface IVoteService {

    VoteEntity vote(Long userId, Long petitionId) throws VoteNotSavedException;

    List<VoteEntity> getByPetitionId(Long petitionId);

}
