package com.example.herokudemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class MyUser {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String password;
    private String phone;
    private String gender;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<MyOrder> orders;

    // recursive
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="manager_id")
    private MyUser manager;

    @OneToMany(mappedBy="manager", cascade = CascadeType.ALL)
    private Set<MyUser> staffs;
}
