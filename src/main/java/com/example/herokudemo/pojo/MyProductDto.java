package com.example.herokudemo.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MyProductDto {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
}
