package com.example.warehouse.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double quantity;

    @ManyToOne()
    private WareHouse wareHouse;

    @OneToOne(mappedBy = "stock")
    private Product product;

    public void increaseQuantity(double quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity(double quantity) {
        if (quantity < getQuantity())
            this.quantity -= quantity;
        else
            throw new IllegalArgumentException("Not enough product");
    }

}
