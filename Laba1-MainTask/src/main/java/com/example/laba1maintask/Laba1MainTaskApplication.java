package com.example.laba1maintask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@Order(2)
public class Laba1MainTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println("Begin of Main!");
        SpringApplication.run(Laba1MainTaskApplication.class, args);
        System.out.println("End of Main!");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hi from Spring Boot!");
    }
}
