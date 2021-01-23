package com.example.herokudemo.repositories;


import com.example.herokudemo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
//    @Query("SELECT u FROM Book u WHERE u.date < now()")
//    List<Book> findAllActiveUsers();

//    @Query("SELECT u.id,u.name FROM User u WHERE u.date < now()")
//    List<Object> specific();
}
