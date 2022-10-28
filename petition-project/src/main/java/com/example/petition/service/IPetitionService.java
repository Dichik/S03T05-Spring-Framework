package com.example.petition.service;


import com.example.petition.entity.PetitionEntity;
import com.example.petition.entity.dto.PetitionDto;
import com.example.petition.exception.PetitionNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPetitionService {
    List<PetitionEntity> findAll();

    Optional<PetitionEntity> findById(Long id);

    void create(PetitionEntity petitionEntity);

    void delete(Long id) throws PetitionNotFoundException;

    Optional<PetitionEntity> update(Long id, PetitionDto petitionDto);
}
