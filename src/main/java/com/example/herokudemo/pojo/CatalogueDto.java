package com.example.herokudemo.pojo;

import com.example.herokudemo.models.Shop;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
public class CatalogueDto {
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    Set<Shop> shopSet = new HashSet<>();

    private Long parentId;
//    private CatalogueDto catalogue;

    private Set<Long> childrenIds;
//    private Set<CatalogueDto> catalogueSet;
}
