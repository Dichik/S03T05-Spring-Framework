package com.example.laba2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Laba2Application {

    public static void main(String[] args) {
        SpringApplication.run(Laba2Application.class, args);
    }

}
