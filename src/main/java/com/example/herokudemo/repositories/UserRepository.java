package com.example.herokudemo.repositories;

import com.example.herokudemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM Book u WHERE u.date < now()")
//    List<Book> findAllActiveUsers();

//    @Query("SELECT u.id,u.name FROM User u WHERE u.date < now()")
//    List<Object> specific();
}
