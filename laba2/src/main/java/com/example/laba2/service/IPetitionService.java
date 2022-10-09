package com.example.laba2.service;

import com.example.laba2.entity.Petition;

import java.util.List;

public interface IPetitionService {
    List<Petition> findAll();

    void create(Petition petition);

    void delete(Long id);
}
