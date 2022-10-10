package com.example.laba2.service;

import com.example.laba2.entity.User;
import com.example.laba2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Optional<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }

}
