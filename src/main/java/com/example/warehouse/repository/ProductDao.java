package com.example.warehouse.repository;

import com.example.warehouse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> getProductsByCategoryId(Integer whId);
    List<Product> getProductsBySupplierId(Integer sId);
}
