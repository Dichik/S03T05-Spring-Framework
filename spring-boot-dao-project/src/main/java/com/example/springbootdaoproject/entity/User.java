package com.example.springbootdaoproject.entity;

public class User {

    private Long id;
    private String email;
    private String firstName;
    private String secondName;

    public User() {

    }

    public User(Long id, String email, String firstName, String secondName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
