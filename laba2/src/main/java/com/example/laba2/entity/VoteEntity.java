package com.example.laba2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "votes")
public class VoteEntity {

    @Id // TODO check out how to create double key and make it foreign
    private Long userId;

    private Long petitionId;

}
