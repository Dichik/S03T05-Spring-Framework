package com.example.petition.service;

import com.example.petition.entity.PetitionEntity;
import com.example.petition.entity.dto.PetitionDto;
import com.example.petition.exception.PetitionNotFoundException;
import com.example.petition.repository.PetitionRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PetitionService implements IPetitionService {

    private ModelMapper modelMapper;

    @Autowired
    private PetitionRepository petitionRepository;

    @Override
    public List<PetitionEntity> findAll() {
        return this.petitionRepository.findAll();
    }

    public Page<PetitionEntity> findAll(Pageable paging) {
        return this.petitionRepository.findAll(paging);
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

}
