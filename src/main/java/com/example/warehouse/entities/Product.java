package com.example.warehouse.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private double price;
    private double value;
    private String unit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private Stock stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.JOIN)
    private List<Order> orders;

    @ManyToOne()
    private Supplier supplier;

    @ManyToOne()
    private Category category;

    public enum Currency {
        UZS, USD, EUR, RUB
    }
}
