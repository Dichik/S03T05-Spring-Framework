package com.example.laba2.controller;

import com.example.laba2.entity.Petition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/petition")
public class PetitionController {

    @GetMapping
    public List<Petition> getAll() {
        return null;
    }

}
