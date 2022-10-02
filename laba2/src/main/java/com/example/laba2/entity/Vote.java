package com.example.laba2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Vote {

    @Id
    private Long id;

    private Long userId;

    private Long petitionId;

    public Vote(Long userId, Long petitionId) {
        this.userId = userId;
        this.petitionId = petitionId;
    }

}
