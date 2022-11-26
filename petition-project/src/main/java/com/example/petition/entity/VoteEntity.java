package com.example.petition.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteEntity {

    @Id
    private Long id;

    private Long userId;

    private Long petitionId;
//
//    @LastModifiedDate
//    private Instant votedAt;

}
