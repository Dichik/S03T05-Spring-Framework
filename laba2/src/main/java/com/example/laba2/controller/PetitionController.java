package com.example.laba2.controller;

import com.example.laba2.entity.PetitionEntity;
import com.example.laba2.entity.dto.PetitionDto;
import com.example.laba2.exception.PetitionNotFoundException;
import com.example.laba2.service.PetitionService;
import lombok.AllArgsConstructor;
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

    @GetMapping
    public String getAll(Model model) {
        List<PetitionEntity> petitions = this.petitionService.findAll();

        log.info("List of petitions were getten. Total size: " + petitions.size());

        model.addAttribute("petitions", petitions);
        return "petition";
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<PetitionDto> getById(@PathVariable Long id) {
        return this.petitionService.findById(id)
                .map(petitionEntity -> {
                    log.info("Petition with " + id + " id was found.");
                    return ResponseEntity.ok(this.modelMapper.map(petitionEntity, PetitionDto.class));
                })
                .orElseThrow(() -> new RuntimeException("Error..."));
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
