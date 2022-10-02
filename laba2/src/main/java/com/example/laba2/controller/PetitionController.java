package com.example.laba2.controller;

import com.example.laba2.entity.Petition;
import com.example.laba2.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/petition")
public class PetitionController {

    @Autowired
    private PetitionService petitionService;

    @GetMapping
    public List<Petition> getAll() {
        return this.petitionService.getAllPetitions();
    }

}
