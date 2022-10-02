package com.example.laba1maintask.conrollers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class Second implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hi from Second!");
    }
}
