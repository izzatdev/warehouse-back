package com.example.warehouse.services;

import com.example.warehouse.entities.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier getById(Integer id);

    Supplier create(Supplier toModel);

    Supplier update(Supplier toModel);

    List<Supplier> getAll();
}
