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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.JOIN)
    private Set<Product> products;
}
