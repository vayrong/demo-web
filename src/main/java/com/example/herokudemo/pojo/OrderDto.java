package com.example.herokudemo.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
public class OrderDto {
    private Long id;
    private String nameCustomer;
    private String addressDelivery ;
    private Double totalPrice;
    private String goods;
    private int amount;

    private Long userId;
//    @JsonIgnore
//    private User user;
}
