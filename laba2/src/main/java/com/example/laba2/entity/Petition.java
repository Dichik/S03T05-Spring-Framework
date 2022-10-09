package com.example.laba2.entity;

import javax.persistence.*;

@Entity
@Table(name = "petition")
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

}
