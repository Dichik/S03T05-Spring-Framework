package com.example.petition.service;


import com.example.petition.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<UserEntity> getUserById(Long id);

    List<UserEntity> getUsers();

    List<UserEntity> getUsersOrderedByEmail();

}
