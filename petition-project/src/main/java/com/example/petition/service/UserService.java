package com.example.petition.service;

import com.example.petition.entity.UserEntity;
import com.example.petition.repository.UserRepository;
import com.example.petition.service.IS;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getUsers() {
        return this.userRepository.findAll();
    }

}
