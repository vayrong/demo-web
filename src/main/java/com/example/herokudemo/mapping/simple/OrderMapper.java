package com.example.herokudemo.mapping.simple;


import com.example.herokudemo.models.Order;
import com.example.herokudemo.pojo.OrderDto;

public class OrderMapper {
    public static Order dtoToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setAmount(orderDto.getAmount());

//        orderDto.getUserId();
        return order;
    }
}
