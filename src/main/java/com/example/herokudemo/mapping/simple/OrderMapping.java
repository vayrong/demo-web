package com.example.herokudemo.mapping.simple;


import com.example.herokudemo.models.Order;
import com.example.herokudemo.pojo.OrderDto;

public class OrderMapping {
    public static OrderDto entityToDto(Order object) {
        OrderDto result = new OrderDto();
        result.setAmount(object.getAmount());
        result.setId(object.getId());
        result.setUserId(object.getUser().getId());
        return result;
    }
    public static Order dtoToEntity(OrderDto object) {
        Order result = new Order();
        result.setAmount(object.getAmount());
        result.setId(object.getId());
//        result.setUserId(object.getUser().getId());
        return result;
    }
}
