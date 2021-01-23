package com.example.herokudemo.mapping.simple;


import com.example.herokudemo.models.User;
import com.example.herokudemo.pojo.UserDto;

public class UserMapper {
    public static User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setAddress(userDto.getAddress());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
