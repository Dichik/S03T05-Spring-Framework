package com.example.laba2.service;

import com.example.laba2.entity.Petition;
import com.example.laba2.entity.dto.PetitionDto;

import java.util.List;
import java.util.Optional;

public interface IPetitionService {
    List<Petition> findAll();

    void create(Petition petition);

    void delete(Long id);

    Optional<Petition> update(Long id, PetitionDto petitionDto);
}
