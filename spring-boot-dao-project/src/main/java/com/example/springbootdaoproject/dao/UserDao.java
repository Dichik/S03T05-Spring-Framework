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
        return (long) this.jdbcTemplate.update(
                "insert into users(email, firstName, secondName) values (?, ?, ?)",
                user.getEmail(), user.getFirstName(), user.getSecondName());
    }

    @Override
    public Optional<User> getById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from users where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new User.UserBuilder(rs.getString("email"))
                                .setId(rs.getLong("id"))
                                .setFirstName(rs.getString("firstName"))
                                .setSecondName(rs.getString("secondName"))
                                .build())
        );
    }

    public Optional<User> getByEmail(String email) {
        return jdbcTemplate.queryForObject(
                "select * from users where email = ?",
                new Object[]{email},
                (rs, rowNum) ->
                        Optional.of(new User.UserBuilder(rs.getString("email"))
                                .setId(rs.getLong("id"))
                                .setFirstName(rs.getString("firstName"))
                                .setSecondName(rs.getString("secondName"))
                                .build())
        );
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(
                "update users set email = ? where id = ?",
                user.getEmail(), user.getId());
    }

    @Override
    public Long deleteById(Long id) {
        return (long) this.jdbcTemplate.update("delete users where id=?", id);
    }

    @Override
    public List<User> getAll() {
        return this.jdbcTemplate.query(
                "select * from users",
                (rs, rowNum) ->
                        new User.UserBuilder(rs.getString("email"))
                                .setId(rs.getLong("id"))
                                .setFirstName(rs.getString("firstName"))
                                .setSecondName(rs.getString("secondName"))
                                .build()
        );
    }

}
