package com.example.springbootdaoproject.entity;

public class User {

    private Long id;
    private String email;
    private String firstName;
    private String secondName;

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
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

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public static class UserBuilder {

        private Long id;
        private String email;
        private String firstName;
        private String secondName;

        public UserBuilder(String email) {
            this.email = email;
        }

        public UserBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}
