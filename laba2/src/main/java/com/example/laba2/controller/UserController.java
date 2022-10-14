package com.example.laba2.controller;

import com.example.laba2.entity.dto.UserDto;
import com.example.laba2.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

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
