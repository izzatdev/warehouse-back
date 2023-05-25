package com.example.warehouse.controllers;

import com.example.warehouse.dtos.warehouse.WareHouseCreateDto;
import com.example.warehouse.dtos.warehouse.WareHouseShowDto;
import com.example.warehouse.dtos.warehouse.WareHouseUpdateDto;
import com.example.warehouse.mappers.WareHouseMapper;
import com.example.warehouse.services.WareHouseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/warehouse")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class WareHouseController {
    private final WareHouseService wareHouseService;
    private final WareHouseMapper mapper;

    @GetMapping("/get-all")
    public List<WareHouseShowDto> getAll() {
        return wareHouseService.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}/get")
    public WareHouseShowDto getById(@PathVariable Integer id) {
        return mapper.toDto(wareHouseService.getById(id));
    }

    @PostMapping("/create")
    public WareHouseShowDto create(@RequestBody WareHouseCreateDto wareHouseCreateDto) {
        return mapper.toDto(wareHouseService.create(mapper.toModel(wareHouseCreateDto)));
    }

    @PutMapping("/update")
    public WareHouseShowDto update(@RequestBody WareHouseUpdateDto wareHouseUpdateDto) {
        return mapper.toDto(wareHouseService.update(mapper.toModel(wareHouseUpdateDto)));
    }
}
