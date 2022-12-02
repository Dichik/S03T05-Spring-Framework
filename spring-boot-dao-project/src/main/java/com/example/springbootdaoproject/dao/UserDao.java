package com.example.springbootdaoproject.dao;

import com.example.springbootdaoproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao implements Dao<User> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long create(User user) {

        return 0L;
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

}
