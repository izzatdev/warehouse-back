package com.example.warehouse.services;

import com.example.warehouse.dtos.orders.OrderCreateDto;
import com.example.warehouse.dtos.orders.OrderUpdateDto;
import com.example.warehouse.entities.Order;

public interface OrderService {
    Order create(OrderCreateDto orderCreateDto);

    Order getById(Integer id);

    void cancelOrderById(Integer id);

}
