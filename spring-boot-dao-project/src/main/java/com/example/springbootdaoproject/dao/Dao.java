package com.example.springbootdaoproject.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Long create(T t);

    Optional<T> getById(Long id);

    void update(T t);

    Long deleteById(Long id);

    List<T> getAll();

}
