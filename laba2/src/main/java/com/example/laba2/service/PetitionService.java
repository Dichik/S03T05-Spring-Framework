package com.example.laba2.service;

import com.example.laba2.entity.Petition;
import com.example.laba2.repository.PetitionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetitionService implements IPetitionService {

    private final PetitionRepository petitionRepository;
//
//    // TODO optional add
//    public List<Petition> getAllPetitions() {
//        List<Petition> petitions = (List<Petition>) this.petitionRepository.findAll();
//        if (petitions.isEmpty()) {
//            System.out.println("Petitions are empty :(");
//        }
//        return petitions;
//    }

}
