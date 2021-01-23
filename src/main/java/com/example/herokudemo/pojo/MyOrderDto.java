package com.example.herokudemo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MyOrderDto {
    private Long id;
    private String nameCustomer;
    private String addressDelivery ;
    private Double totalPrice;
    private String goods;
    private int amount;

    private Long userId;
    private List<Long> productIds;
}
