package com.example.laba2.service;

import com.example.laba2.entity.PetitionEntity;
import com.example.laba2.entity.dto.PetitionDto;
import com.example.laba2.exception.PetitionNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPetitionService {
    List<PetitionEntity> findAll();

    Optional<PetitionEntity> findById(Long id);

    void create(PetitionEntity petitionEntity);

    void delete(Long id) throws PetitionNotFoundException;

    Optional<PetitionEntity> update(Long id, PetitionDto petitionDto);
}
