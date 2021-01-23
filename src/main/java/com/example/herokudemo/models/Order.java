package com.example.herokudemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="[order]")
@Data
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String nameCustomer;
    private String addressDelivery ;
    private Double totalPrice;
    private String goods;
    private int amount;

//    @Transient
//    private Long userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
//    @OneToMany(mappedBy="order")
//    private Set<User> items;
}
