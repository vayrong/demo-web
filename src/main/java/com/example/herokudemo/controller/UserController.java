package com.example.herokudemo.controller;

import com.example.herokudemo.mapping.simple.UserMapper;
import com.example.herokudemo.models.User;
import com.example.herokudemo.pojo.UserDto;
import com.example.herokudemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/save")
    String saveUser(@RequestBody UserDto userDto) {
        User user = UserMapper.dtoToEntity(userDto);
        userRepository.save(user);
        return "success";
    }
}
