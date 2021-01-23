package com.example.herokudemo.controller;

import com.example.herokudemo.pojo.OrderDto;
import com.example.herokudemo.repositories.UserRepository;
import com.example.herokudemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderService orderService;

    @PostMapping("/save-order")
    String sum(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
        return "success";
    }

//    @GetMapping("/giaithua")
//    Integer giaiThua(@RequestParam("a") Integer one) {
//        int giaiThua = 1;
//        if (one <= 1) {
//            giaiThua = 1;
//        } else {
//            for (int i = 2; i <= one; i++) {
//                giaiThua *= i;
//            }
//        }
//        return giaiThua;
//    }

}
