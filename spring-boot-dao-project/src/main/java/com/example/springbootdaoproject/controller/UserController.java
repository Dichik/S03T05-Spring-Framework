package com.example.springbootdaoproject.controller;

import com.example.springbootdaoproject.entity.User;
import com.example.springbootdaoproject.entity.dto.UserDto;
import com.example.springbootdaoproject.exception.InvalidIdentifierException;
import com.example.springbootdaoproject.exception.InvalidUserIdException;
import com.example.springbootdaoproject.service.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return this.userService.getAll().stream()
                .map(user -> this.modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id:\\d+}")
    public User getById(@PathVariable Long id) {
        return this.userService.getById(id).orElseThrow(() -> new InvalidIdentifierException(id));
    }

    @GetMapping("/{email:\\s+}")
    public User getByEmail(@PathVariable String email) {
        return this.userService.getByEmail(email).orElseThrow(() -> new InvalidIdentifierException(email));
    }

    @PostMapping
    public Long create(@RequestBody @Valid UserDto userDto) {
        return this.userService.create(this.modelMapper.map(userDto, User.class));
    }

    @PutMapping("/{id:\\d+}")
    public void update(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        try {
            this.userService.update(id, userDto);
        } catch (InvalidUserIdException e) {
            logger.error("Error occurred, see: " + e);
            throw new InvalidIdentifierException(id);
        }
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable Long id) {
        this.userService.deleteById(id);
    }

}
