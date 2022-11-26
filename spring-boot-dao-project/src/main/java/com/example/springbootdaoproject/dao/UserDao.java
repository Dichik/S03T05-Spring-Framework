package com.example.springbootdaoproject.dao;

import com.example.springbootdaoproject.entity.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {

    // TODO research https://www.baeldung.com/java-dao-pattern

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }
}
