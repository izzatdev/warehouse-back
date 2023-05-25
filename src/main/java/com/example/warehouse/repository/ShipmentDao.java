package com.example.warehouse.repository;

import com.example.warehouse.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentDao extends JpaRepository<Shipment, Integer> {
}
