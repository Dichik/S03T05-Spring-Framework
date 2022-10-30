package com.example.petition.controller;

import com.example.petition.entity.PetitionEntity;
import com.example.petition.entity.dto.PetitionDto;
import com.example.petition.exception.PetitionNotFoundException;
import com.example.petition.service.PetitionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/petition")
public class PetitionController {

    private final PetitionService petitionService;
    private final ModelMapper modelMapper;

    @Autowired
    public PetitionController(PetitionService petitionService, ModelMapper modelMapper) {
        this.petitionService = petitionService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        List<PetitionEntity> petitions = this.petitionService.findAll();

        log.info("List of petitions were getten. Total size: " + petitions.size());

        model.addAttribute("petitions", petitions);
        return "petition";
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
    public String getById(@PathVariable Long id, Model model) {
        PetitionDto petition = this.petitionService.findById(id)
                .map(petitionEntity -> {
                    log.info("Petition with " + id + " id was found.");
                    return this.modelMapper.map(petitionEntity, PetitionDto.class);
                }).orElse(null);

        model.addAttribute("petition", petition);

        return "petition_page";
    }

    @PostMapping
    public void create(@Valid @RequestBody PetitionDto petitionDto) {
        PetitionEntity petition = this.modelMapper.map(petitionDto, PetitionEntity.class);
        this.petitionService.create(petition); // TODO improve PostMapping method
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable Long id) {
        try {
            this.petitionService.delete(id);
            log.error("Petition with id=" + id + " was successfully deleted."); // TODO research where to add try/catch and how to handle it correctly
            // check out some YouTube videos
        } catch (PetitionNotFoundException e) {
            log.error("Couldn't delete petition with id=" + id + "Error: " + e); // TODO research how to add logging
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<PetitionDto> update(@PathVariable Long id, @Valid @RequestBody PetitionDto petitionDto) {
        return this.petitionService.update(id, petitionDto)
                .map(petitionEntity -> ResponseEntity.ok(this.modelMapper.map(petitionEntity, PetitionDto.class)))
                .orElseThrow(() -> new RuntimeException("Error...")); // fix that
    }

}
