package com.example.herokudemo.repositories;


import com.example.herokudemo.models.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderRepository extends JpaRepository<MyOrder, Long> {
}
