package com.example.herokudemo.repositories;


import com.example.herokudemo.models.MyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyProductRepository extends JpaRepository<MyProduct, Long> {
    @Query("SELECT mp FROM MyProduct mp WHERE mp.price = 0 or mp.price is null")
    List<MyProduct> findAllFree();
}
