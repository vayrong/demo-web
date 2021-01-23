package com.example.herokudemo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MyUserDto {
    private Long id;
    private String name;
    private String address;
    private String password;
    private String phone;
    private String gender;

    private List<Long> orderIds;
//    private List<MyUserDto> myUserDtos;

    // recursive
    private Long managerId;
    private List<Long> staffIds;

    private MyUserDto manager;
}
