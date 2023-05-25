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
@Table(name = "warehouse")
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String location;
    private double capacity;

    @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.JOIN)
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.JOIN)
    private Set<Category> categories;
}
