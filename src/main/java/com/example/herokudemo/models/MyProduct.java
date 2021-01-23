package com.example.herokudemo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class MyProduct {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "my_order_product",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    Set<MyOrder> orders = new HashSet<>();
}
