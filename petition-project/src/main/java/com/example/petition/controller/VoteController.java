package com.example.petition.controller;

import com.example.laba2.entity.VoteEntity;
import com.example.laba2.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public String getAll(@RequestParam Long petitionId, Model model) {
        List<VoteEntity> votes = this.voteService.getAll(); // should get by petition id

        model.addAttribute("votes", votes);

        return "vote";
    }

    @GetMapping("/{petitionId:[\\d]+}") // TODO improve parameter for petition_id
    public Long getNumberOfVotes(@RequestParam Long petitionId) {
        return this.voteService.getNumberOfVotesByPetitionId(petitionId);
    }

    @PostMapping
    public VoteEntity vote(@RequestParam Long userId, @RequestParam Long petitionId) {
        return this.voteService.vote(userId, petitionId);
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void removeVote(@PathVariable Long id) {

    }

}
