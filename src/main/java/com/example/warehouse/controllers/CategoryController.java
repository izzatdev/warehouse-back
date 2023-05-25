package com.example.warehouse.controllers;

import com.example.warehouse.dtos.category.CategoryCreateDto;
import com.example.warehouse.dtos.category.CategoryShowDto;
import com.example.warehouse.dtos.category.CategoryUpdateDto;
import com.example.warehouse.dtos.warehouse.WareHouseCreateDto;
import com.example.warehouse.dtos.warehouse.WareHouseShowDto;
import com.example.warehouse.dtos.warehouse.WareHouseUpdateDto;
import com.example.warehouse.mappers.CategoryMapper;
import com.example.warehouse.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/category")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper mapper;

    @GetMapping("/get-all")
    public List<CategoryShowDto> getAll() {
        return categoryService.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}/get")
    public CategoryShowDto getById(@PathVariable Integer id) {
        return mapper.toDto(categoryService.getById(id));
    }

    @GetMapping("/get-by-warehouse/{id}")
    public List<CategoryShowDto> getByWareHouseId(@PathVariable Integer id) {
        return categoryService.getByWareHouseId(id).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public CategoryShowDto create(@RequestBody CategoryCreateDto categoryCreateDto) {
        return mapper.toDto(categoryService.create(mapper.toModel(categoryCreateDto)));
    }

    @PutMapping("/update")
    public CategoryShowDto update(@RequestBody CategoryUpdateDto categoryUpdateDto) {
        return mapper.toDto(categoryService.update(mapper.toModel(categoryUpdateDto)));
    }

}
