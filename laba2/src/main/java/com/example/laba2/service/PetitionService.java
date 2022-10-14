package com.example.laba2.service;

import com.example.laba2.entity.Petition;
import com.example.laba2.entity.dto.PetitionDto;
import com.example.laba2.exception.PetitionNotFoundException;
import com.example.laba2.repository.PetitionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PetitionService implements IPetitionService {

    private final ModelMapper modelMapper;
    private final PetitionRepository petitionRepository;

    @Override
    public List<Petition> findAll() {
        return this.petitionRepository.findAll();
    }

    @Override
    public Optional<Petition> findById(Long id) {
        return this.petitionRepository.findById(id);
    }

    @Override
    public void create(Petition petition) {
        this.petitionRepository.save(petition);
    }

    @Override
    public void delete(Long id) throws PetitionNotFoundException {
        Petition petition = this.petitionRepository.findById(id).orElse(null);
        if (petition == null) {
            log.error("Petition entity with " + id + " id was not found.");
            throw new PetitionNotFoundException("Can't delete petition with " + id + " id");
        }
        this.petitionRepository.delete(petition);
    }

    @Override
    public Optional<Petition> update(Long id, PetitionDto petitionDto) {
        return this.petitionRepository.findById(id)
            .map(source -> {
                Petition petition = modelMapper.map(petitionDto, Petition.class);
                petition.setId(id);
                return this.petitionRepository.save(petition);
            });
    }

}
