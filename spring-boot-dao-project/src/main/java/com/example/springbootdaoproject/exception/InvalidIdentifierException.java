package com.example.springbootdaoproject.exception;

public class InvalidIdentifierException extends RuntimeException {

    public InvalidIdentifierException(Long id) {
        super("Invalid id: " + id);
    }

}
