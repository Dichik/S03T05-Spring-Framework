package com.example.laba2.controller;

import com.example.laba2.entity.Petition;
import com.example.laba2.service.PetitionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/petition")
public class PetitionController {

    private final PetitionService petitionService;

    @GetMapping
    public String getAll(Model model) {

        List<Petition> petitions = this.petitionService.getAllPetitions();

        model.addAttribute("petitions", petitions);

        return "petition";
    }

}
