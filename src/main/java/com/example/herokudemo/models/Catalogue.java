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
public class Catalogue {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "shop_cata",
            joinColumns = { @JoinColumn(name = "cata_id") },
            inverseJoinColumns = { @JoinColumn(name = "shop_id") }
    )
    Set<Shop> shopSet = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Catalogue catalogue;

    @OneToMany(mappedBy = "catalogue", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Catalogue> catalogueSet;
}
