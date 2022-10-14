package com.example.laba2.service;

import com.example.laba2.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<User> getUserById(Long id);

    List<User> getUsers();

}
