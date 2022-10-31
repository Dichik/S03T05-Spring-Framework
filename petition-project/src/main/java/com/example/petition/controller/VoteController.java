package com.example.petition.controller;

import com.example.petition.entity.VoteEntity;
import com.example.petition.entity.dto.VoteDto;
import com.example.petition.exception.VoteNotSavedException;
import com.example.petition.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;
    private final ModelMapper modelMapper;

    @Autowired
    public VoteController(VoteService voteService, ModelMapper modelMapper) {
        this.voteService = voteService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
    public String getAllByPetitionId(@PathVariable Long id, Model model) {
        List<VoteEntity> votes = this.voteService.getByPetitionId(id);
        log.info("Got " + votes.size() + " votes, see: " + votes);
        model.addAttribute("votes", votes);
        return "vote";
    }

    @PostMapping
    public ResponseEntity<VoteDto> vote(@RequestParam Long userId, @RequestParam Long petitionId) {
        try {
            return ResponseEntity.ok(
                    this.modelMapper.map(this.voteService.vote(userId, petitionId), VoteDto.class)
            );
        } catch (VoteNotSavedException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void removeVote(@PathVariable Long id) {
        // TODO implement method
    }

}
