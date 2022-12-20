package com.example.petition.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetitionEntity {

    @Id
    private Long id;

    private String title;

    private String description;

}
