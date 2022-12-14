package com.example.petition.controller;

import com.example.petition.entity.dto.UserDto;
import com.example.petition.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id)
                .map(user -> {
                    log.info("User with " + id + " id was found.");
                    return ResponseEntity.ok(this.modelMapper.map(user, UserDto.class));
                }).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return this.userService.getUsers().stream()
                .map(user -> this.modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<UserDto> getUsersOrderedByEmail(@RequestParam Boolean orderByEmail) {
        if (orderByEmail) {
            return this.userService.getUsersOrderedByEmail().stream()
                    .map(user -> this.modelMapper.map(user, UserDto.class))
                    .collect(Collectors.toList());
        } else {
            return getUsers();
        }
    }

}
