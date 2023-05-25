package com.example.warehouse.services;

import com.example.warehouse.entities.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    Collection<Category> getAll();

    Category getById(Integer id);

    Category create(Category toModel);

    Category update(Category toModel);

    List<Category> getByWareHouseId(Integer id);
}
