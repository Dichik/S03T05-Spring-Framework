package com.example.laba2.service;

import com.example.laba2.entity.Petition;
import com.example.laba2.repository.PetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetitionService implements IPetitionService {

    private final PetitionRepository petitionRepository;

    // TODO optional add
    public List<Petition> getAllPetitions() {
        return List.of(new Petition(1L, "Petition #1"));
    }

}
