package com.example.laba2.controller;

import com.example.laba2.entity.Vote;
import com.example.laba2.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public List<Vote> getAll() {
        return null;
    }

    @GetMapping("/id")
    public Vote getById(@RequestParam Long id) {
        return null;
    }

    @PostMapping
    public Vote vote(@RequestParam Long userId, @RequestParam Long petitionId) {
        return null;
    }

}
