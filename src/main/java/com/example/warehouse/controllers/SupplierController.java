package com.example.warehouse.controllers;

import com.example.warehouse.dtos.supplier.SupplierCreateDto;
import com.example.warehouse.dtos.supplier.SupplierShowDto;
import com.example.warehouse.dtos.supplier.SupplierUpdateDto;
import com.example.warehouse.dtos.warehouse.WareHouseCreateDto;
import com.example.warehouse.dtos.warehouse.WareHouseShowDto;
import com.example.warehouse.dtos.warehouse.WareHouseUpdateDto;
import com.example.warehouse.mappers.SupplierMapper;
import com.example.warehouse.services.SupplierService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/supplier")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    private final SupplierMapper mapper;

    @GetMapping("/get-all")
    public List<SupplierShowDto> getAll() {
        return supplierService.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}/get")
    public SupplierShowDto getById(@PathVariable Integer id) {
        return mapper.toDto(supplierService.getById(id));
    }

    @PostMapping("/create")
    public SupplierShowDto create(@RequestBody SupplierCreateDto supplierCreateDto) {
        return mapper.toDto(supplierService.create(mapper.toModel(supplierCreateDto)));
    }

    @PutMapping("/update")
    public SupplierShowDto update(@RequestBody SupplierUpdateDto supplierUpdateDto) {
        return mapper.toDto(supplierService.update(mapper.toModel(supplierUpdateDto)));
    }
}
