package com.example.laba2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Petition {

    @Id
    private Long id;

    private String description;

}
