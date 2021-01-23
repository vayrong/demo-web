package com.example.herokudemo.controller;

import com.example.herokudemo.models.Order;
import com.example.herokudemo.models.User;
import com.example.herokudemo.pojo.OrderDto;
import com.example.herokudemo.repositories.OrderRepository;
import com.example.herokudemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/order/add")
    String addOrder(@RequestBody OrderDto orderDto) {
//        Order order = OrderMapper.dtoToEntity(orderDto);
        Order order = new Order();
        order.setAmount(orderDto.getAmount());


        Optional<User> user = userRepository.findById(orderDto.getUserId());
        if (user.isPresent()) {
            order.setUser(user.get());
            orderRepository.save(order);
        }
        return "success";
    }
}
