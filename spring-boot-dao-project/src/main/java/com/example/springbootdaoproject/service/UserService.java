package com.example.springbootdaoproject.service;

import com.example.springbootdaoproject.dao.UserDao;
import com.example.springbootdaoproject.entity.User;
import com.example.springbootdaoproject.entity.dto.UserDto;
import com.example.springbootdaoproject.exception.InvalidUserIdException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    public List<User> getAll() {
        return this.userDao.getAll();
    }

    public Optional<User> getById(Long id) {
        return this.userDao.getById(id);
    }

    public Optional<User> getByEmail(String email) {
        return this.userDao.getByEmail(email);
    }

    public Long create(User user) {
        return this.userDao.create(user);
    }

    public void update(Long id, UserDto userDto) throws InvalidUserIdException {
        if (this.userDao.getById(id).isEmpty()) {
            throw new InvalidUserIdException("Id is not valid, you can't update user.");
        }
        User user = this.modelMapper.map(userDto, User.class);
        user.setId(id);
        this.userDao.update(user);
    }

    public void deleteById(Long id) {
        this.userDao.deleteById(id);
    }

}
