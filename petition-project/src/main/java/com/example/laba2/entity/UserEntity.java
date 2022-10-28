package com.example.laba2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    // TODO only registered users can vote (easy registration maybe with mail confirmation)
    // TODO confirmation by clicing url -> interesting to design that???
    // TODO Spring Security is ok for that? would be a good practice to test it on an easy application
    @Id @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String firstName;

    private String secondName;

}
