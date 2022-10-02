package com.example.laba2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    // TODO only registered users can vote (easy registration maybe with mail confirmation)
    // TODO confirmation by clicing url -> interesting to design that???
    // TODO Spring Security is ok for that? would be a good practice to test it on an easy application
    @Id
    private Long id;

    private String email;

    private String firstName;

    private String secondName;

}
