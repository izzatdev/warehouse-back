package com.example.warehouse.repository;

import com.example.warehouse.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer> {
    Optional<Stock> getStockByProductId(Integer id);
}
