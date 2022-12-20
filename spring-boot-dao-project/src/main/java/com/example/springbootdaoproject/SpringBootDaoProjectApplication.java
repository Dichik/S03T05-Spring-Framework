package com.example.springbootdaoproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootDaoProjectApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDaoProjectApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDaoProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("StartApplication...");
        runJDBC();
    }

    void runJDBC() {
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users(" +
                "id SERIAL, " +
                "email VARCHAR(255)," +
                "firstName VARCHAR(255)," +
                "secondName VARCHAR(255))");
        this.jdbcTemplate.execute("INSERT INTO users(email, firstName, secondName) VALUES ('test@email.com', 'Ostap','Petrenko')");
    }

}
