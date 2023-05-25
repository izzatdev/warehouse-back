package com.example.warehouse.controllers;

import com.example.warehouse.dtos.product.ProductCreateDto;
import com.example.warehouse.dtos.product.ProductMainDto;
import com.example.warehouse.dtos.product.ProductUpdateDto;
import com.example.warehouse.mappers.ProductMapper;
import com.example.warehouse.services.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/product")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper mapper;

    @PostMapping("/create")
    public ProductMainDto create(@RequestBody ProductCreateDto productCreateDto) {
        return mapper.toDto(productService.create(productCreateDto));
    }


    @GetMapping("/{id}/get")
    public ProductMainDto getById(@PathVariable Integer id) {
        return mapper.toDto(productService.getById(id));
    }

    @GetMapping("/get-all")
    public List<ProductMainDto> getAll() {
        return productService.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/get-by-category/{id}")
    public List<ProductMainDto> getByCategoryId(@PathVariable Integer id) {
        return productService.getByCategoryId(id).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/get-by-supplier/{id}")
    public List<ProductMainDto> getBySupplierId(@PathVariable Integer id) {
        return productService.getBySupplierId(id).stream().map(mapper::toDto).collect(Collectors.toList());
    }


    @PutMapping("/update")
    public ProductMainDto update(@RequestBody ProductUpdateDto productUpdateDto) {
        return mapper.toDto(productService.update(productUpdateDto));
    }

}
