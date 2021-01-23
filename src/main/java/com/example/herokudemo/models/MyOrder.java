package com.example.herokudemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class MyOrder {
    @Id
    @GeneratedValue
    private Long id;
    private String nameCustomer;
    private String addressDelivery ;
    private Double totalPrice;
    private String goods;
    private int amount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private MyUser user;

    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Set<MyProduct> products = new HashSet<>();
}
