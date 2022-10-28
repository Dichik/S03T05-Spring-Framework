package com.example.laba2.service;

import com.example.laba2.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<UserEntity> getUserById(Long id);

    List<UserEntity> getUsers();

}
