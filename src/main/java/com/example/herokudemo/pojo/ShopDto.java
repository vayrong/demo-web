package com.example.herokudemo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
public class ShopDto {
    private Long id;
    private String name;
    private String description;
    private String address;

//    private Long user_id;
//    User user;

//    Set<Catalogue> catalogueSet = new HashSet<>();
}
