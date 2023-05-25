package com.example.warehouse.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;
    private String contact;
    private int shippingDays;

    @OneToOne(mappedBy = "shipment")
    private Order order;
}
