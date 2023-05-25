package com.example.warehouse.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime orderDateTime;
    private double totalAmount;
    private double totalPrice;
    @ManyToOne()
    private Product product;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Shipment shipment;
}
