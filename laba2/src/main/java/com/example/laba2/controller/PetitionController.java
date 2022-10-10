package com.example.laba2.controller;

import com.example.laba2.entity.Petition;
import com.example.laba2.entity.dto.PetitionDto;
import com.example.laba2.service.PetitionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/petition")
public class PetitionController {

    private final PetitionService petitionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getAll(Model model) {
        List<Petition> petitions = this.petitionService.findAll();

        model.addAttribute("petitions", petitions);

        return "petition";
    }

    @PostMapping
    public void create(@Valid @RequestBody Petition petition) {
        this.petitionService.create(petition);
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable Long id) {
        this.petitionService.delete(id);
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<PetitionDto> update(@PathVariable Long id, @Valid @RequestBody PetitionDto petitionDto) {
        return this.petitionService.update(id, petitionDto)
                .map(petition -> ResponseEntity.ok(modelMapper.map(petition, PetitionDto.class)))
                .orElseThrow(() -> new RuntimeException("Error...")); // fix that
    }

}
