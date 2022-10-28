package com.example.petition.exception;

public class UserAlreadyVotedException extends Exception {

    public UserAlreadyVotedException(String message) {
        super(message);
    }

}
