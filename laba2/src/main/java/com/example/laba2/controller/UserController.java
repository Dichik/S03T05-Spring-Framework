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

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return this.userService.getUser(id)
                .map(user -> ResponseEntity.ok(modelMapper.map(user, UserDto.class)))
                .orElseThrow(() -> new RuntimeException("Error"));
    }

}
