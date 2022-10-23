package com.example.laba2.service;

import com.example.laba2.entity.PetitionEntity;
import com.example.laba2.entity.dto.PetitionDto;
import com.example.laba2.exception.PetitionNotFoundException;
import com.example.laba2.repository.PetitionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PetitionService implements IPetitionService {

    private ModelMapper modelMapper;
    private PetitionRepository petitionRepository;

    @Override
    public List<PetitionEntity> findAll() {
        return this.petitionRepository.findAll();
    }

    @Override
    public Optional<PetitionEntity> findById(Long id) {
        return this.petitionRepository.findById(id);
    }

    @Override
    public void create(PetitionEntity petitionEntity) {
        this.petitionRepository.save(petitionEntity);
    }

    @Override
    public void delete(Long id) throws PetitionNotFoundException {
        PetitionEntity petition = this.petitionRepository.findById(id).orElse(null);
        if (petition == null) {
            log.error("Petition entity with " + id + " id was not found.");
            throw new PetitionNotFoundException("Can't delete petition with " + id + " id");
        }
        this.petitionRepository.delete(petition);
    }

    @Override
    public Optional<PetitionEntity> update(Long id, PetitionDto petitionDto) {
        return this.petitionRepository.findById(id)
            .map(source -> {
                PetitionEntity petition = modelMapper.map(petitionDto, PetitionEntity.class);
                petition.setId(id);
                return this.petitionRepository.save(petition);
            });
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setPetitionRepository(PetitionRepository petitionRepository) {
        this.petitionRepository = petitionRepository;
    }
    
}
