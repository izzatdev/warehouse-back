package com.example.warehouse.repository;

import com.example.warehouse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
    List<Category> findAllByWareHouseId(Integer id);
}
