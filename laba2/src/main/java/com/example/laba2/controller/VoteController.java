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

    @Autowired
    private VoteService voteService;

    @GetMapping
    public List<Vote> getAll() {
        return this.voteService.getAll();
    }

    @GetMapping("/id")
    public Vote getById(@RequestParam Long id) {
        return this.voteService.getById(id);
    }

    @PostMapping
    public Vote vote(@RequestParam Long userId, @RequestParam Long petitionId) {
        return this.voteService.vote(userId, petitionId);
    }

}
