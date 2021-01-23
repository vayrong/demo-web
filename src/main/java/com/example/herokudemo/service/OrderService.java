package com.example.herokudemo.service;


import com.example.herokudemo.models.Order;
import com.example.herokudemo.pojo.OrderDto;

public interface OrderService {
    Order saveOrder(OrderDto orderDto);
}
