package com.example.herokudemo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
public class Shop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String address;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "shop_cata",
            joinColumns = { @JoinColumn(name = "shop_id") },
            inverseJoinColumns = { @JoinColumn(name = "cata_id") }
    )
    Set<Catalogue> catalogueSet = new HashSet<>();
}
