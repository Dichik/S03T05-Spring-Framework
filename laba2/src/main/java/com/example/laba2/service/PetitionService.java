package com.example.laba2.service;

import com.example.laba2.entity.Petition;
import com.example.laba2.repository.PetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetitionService implements IPetitionService {

    @Autowired
    private PetitionRepository petitionRepository;

    // TODO optional add
    public List<Petition> getAllPetitions() {
        List<Petition> petitions = (List<Petition>) this.petitionRepository.findAll();
        if (petitions.isEmpty()) {
            System.out.println("Petitions are empty :(");
        }
        return petitions;
    }

}
