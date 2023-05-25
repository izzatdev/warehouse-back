package com.example.warehouse.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne()
    private WareHouse wareHouse;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.JOIN)
    private Set<Product> products;
}
