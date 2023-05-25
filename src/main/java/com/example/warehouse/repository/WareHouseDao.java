package com.example.warehouse.repository;

import com.example.warehouse.entities.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseDao extends JpaRepository<WareHouse, Integer> {
}
