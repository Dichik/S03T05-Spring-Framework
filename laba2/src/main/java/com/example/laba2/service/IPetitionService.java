package com.example.laba2.service;

import com.example.laba2.entity.Petition;
import com.example.laba2.entity.dto.PetitionDto;
import com.example.laba2.exception.PetitionNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPetitionService {
    List<Petition> findAll();

    Optional<Petition> findById(Long id);

    void create(Petition petition);

    void delete(Long id) throws PetitionNotFoundException;

    Optional<Petition> update(Long id, PetitionDto petitionDto);
}
