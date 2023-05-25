package com.example.warehouse.services;

import com.example.warehouse.dtos.product.ProductCreateDto;
import com.example.warehouse.dtos.product.ProductUpdateDto;
import com.example.warehouse.entities.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductCreateDto productMainDto);

    Product getById(Integer id);

    List<Product> getAll();

    List<Product> getByCategoryId(Integer id);

    List<Product> getBySupplierId(Integer id);

    Product update(ProductUpdateDto productUpdateDto);
}
