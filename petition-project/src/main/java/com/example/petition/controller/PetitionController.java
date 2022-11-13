package com.example.petition.controller;

import com.example.petition.entity.PetitionEntity;
import com.example.petition.entity.dto.PetitionDto;
import com.example.petition.exception.PetitionNotFoundException;
import com.example.petition.service.PetitionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public String getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            Model model
    ) {
        Pageable paging = PageRequest.of(page, size);
        Page<PetitionEntity> pagePetitions = this.petitionService.findAll(paging);
        List<PetitionEntity> petitions = pagePetitions.getContent();

        log.info("List of petitions were gotten. Total size: " + petitions.size());

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
    public ResponseEntity<String> create(@Valid @RequestBody PetitionDto petitionDto) {
        PetitionEntity petition = this.modelMapper.map(petitionDto, PetitionEntity.class);
        this.petitionService.create(petition);
        return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be created (CODE 201)\n");
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            this.petitionService.delete(id);
            log.info("Petition with id=" + id + " was successfully deleted.");
            return ResponseEntity.status(HttpStatus.OK).body("Deleted. HTTP Status will be CODE 200.\n");
        } catch (PetitionNotFoundException e) {
            log.error("Couldn't delete petition with id=" + id + "Error: " + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Deleted. HTTP Status will be CODE 404.\n");
        }
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<PetitionDto> update(@PathVariable Long id, @Valid @RequestBody PetitionDto petitionDto) {
        return this.petitionService.update(id, petitionDto)
                .map(petitionEntity -> {
                    PetitionDto petition = this.modelMapper.map(petitionEntity, PetitionDto.class);
                    return ResponseEntity.ok(petition);
                }).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

}
