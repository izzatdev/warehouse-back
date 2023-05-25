package com.example.warehouse.dtos.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDto {
    protected double totalAmount;
    protected double totalPrice;
    protected String address;
    protected String contact;
    protected int shippingDays;
    private Integer productId;
}
