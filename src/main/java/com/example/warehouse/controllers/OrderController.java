package com.example.warehouse.controllers;

import com.example.warehouse.dtos.orders.OrderCreateDto;
import com.example.warehouse.dtos.orders.OrderShowDto;
import com.example.warehouse.mappers.OrderMapper;
import com.example.warehouse.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper mapper;

    @PostMapping("/create")
    @Operation(summary = " only ADMIN or SUPER ADMIN ROLE accessed")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public OrderShowDto create(@RequestBody OrderCreateDto orderCreateDto) {
        return mapper.toDto(orderService.create(orderCreateDto));
    }

    @GetMapping("/{id}/get")
    @Operation(summary = " only ADMIN or SUPER ADMIN ROLE accessed")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public OrderShowDto getById(@PathVariable Integer id) {
        return mapper.toDto(orderService.getById(id));
    }

    @PutMapping("/{id}/cancel")
    @Operation(summary = " only ADMIN or SUPER ADMIN ROLE accessed")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public void cancelOrder(@PathVariable Integer id) {
        orderService.cancelOrderById(id);
    }

}
