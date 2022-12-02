package com.example.springbootdaoproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSource {

    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }

}
