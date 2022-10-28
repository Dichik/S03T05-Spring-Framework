package com.example.petition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetitionApplication.class, args);
    }

    // TODO how we should find out when petition collected required amount of votes
}
