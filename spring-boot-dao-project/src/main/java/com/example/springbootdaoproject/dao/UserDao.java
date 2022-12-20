package com.example.springbootdaoproject.dao;

import com.example.springbootdaoproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
                (rs, rowNum) -> Optional.of(createUserByResultSet(rs))
        );
    }

    public Optional<User> getByEmail(String email) {
        return jdbcTemplate.queryForObject(
                "select * from users where email = ?",
                new Object[]{email},
                (rs, rowNum) -> Optional.of(createUserByResultSet(rs))
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
        return (long) this.jdbcTemplate.update("delete from users where id=?", id);
    }

    @Override
    public List<User> getAll() {
        return this.jdbcTemplate.query(
                "select * from users",
                (rs, rowNum) -> createUserByResultSet(rs)
        );
    }

    private User createUserByResultSet(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("firstName"),
                rs.getString("secondName")
        );
    }

}
