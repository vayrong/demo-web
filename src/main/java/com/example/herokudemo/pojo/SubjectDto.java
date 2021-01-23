package com.example.herokudemo.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
public class SubjectDto {
    private Long id;
    private String name;
//    Set<User> userSet = new HashSet<>();
}
