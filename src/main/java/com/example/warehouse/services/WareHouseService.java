package com.example.warehouse.services;

import com.example.warehouse.entities.WareHouse;

import java.util.List;

public interface WareHouseService {
    List<WareHouse> getAll();

    WareHouse create(WareHouse wareHouse);

    WareHouse update(WareHouse wareHouse);

    WareHouse getById(Integer id);
}
