package com.example.laba2.controller;

import com.example.laba2.entity.Vote;
import com.example.laba2.service.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public String getAll(@RequestParam Long petitionId, Model model) {
        List<Vote> votes = this.voteService.getAll(); // should get by petition id

        model.addAttribute("votes", votes);

        return "vote";
    }

    @GetMapping("/id")
    public Vote getById(@RequestParam Long id) {
        return null;
    }

    @PostMapping
    public Vote vote(@RequestParam Long userId, @RequestParam Long petitionId) {
        return null;
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void vote(@PathVariable Long id) {

    }



}
