package com.example.petition.controller;

import com.example.petition.entity.dto.UserDto;
import com.example.petition.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
                .map(user -> ResponseEntity.ok(this.modelMapper.map(user, UserDto.class)))
                .orElseThrow(() -> new RuntimeException("Error"));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userDtos = this.userService.getUsers().stream()
                .map(user -> this.modelMapper.map(user, UserDto.class))
                .toList();
        return ResponseEntity.ok(userDtos);
    }

}
