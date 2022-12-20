package com.example.petition.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "UserEntity.findAllOrderedByEmail",
        query = "SELECT u FROM users u ORDER BY u.email")
public class UserEntity {
    // TODO only registered users can vote (easy registration maybe with mail confirmation)
    // TODO confirmation by clicking url -> interesting to design that???
    // TODO Spring Security is ok for that? would be a good practice to test it on an easy application

    /**
     * GenerationType.SEQUENCE
     *      Indicates that the persistence provider must assign
     *      primary keys for the entity using a database sequence.
     */
    @Id
    private Long id;

    private String email;

    private String firstName;

    private String secondName;

}
