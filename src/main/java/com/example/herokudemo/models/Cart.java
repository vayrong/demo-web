package com.example.herokudemo.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String address;
    private String phoneNumber;
    private BigDecimal totalMoney;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "cart_product",
            joinColumns = { @JoinColumn(name = "cart_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    Set<Product> products = new HashSet<>();
}
