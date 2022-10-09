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

    @Override
    public List<Petition> findAll() {
        List<Petition> petitions = this.petitionRepository.findAll();
        if (petitions == null) {
            return List.of();
        }
        return petitions;
    }

    @Override
    public void create(Petition petition) {
        this.petitionRepository.save(petition);
    }

    @Override
    public void delete(Long id) {
        Petition petition = this.petitionRepository.findById(id).orElse(null);
        if (petition == null) {
            System.out.println("Can't delete petition with " + id + " id");
        }
        this.petitionRepository.delete(petition);
    }

}
