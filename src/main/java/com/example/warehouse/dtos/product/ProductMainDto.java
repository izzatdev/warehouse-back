package com.example.warehouse.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMainDto {
    protected String name;
    protected String description;
    protected double price;
    protected double value;
    protected String unit;
    protected String currency;
    protected double quantity;
}
