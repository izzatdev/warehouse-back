package com.example.warehouse.services.impls;

import com.example.warehouse.entities.WareHouse;
import com.example.warehouse.exceptions.CustomException;
import com.example.warehouse.repository.CategoryDao;
import com.example.warehouse.entities.Category;
import com.example.warehouse.repository.WareHouseDao;
import com.example.warehouse.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final WareHouseDao wareHouseDao;

    @Override
    public Collection<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    public Category create(Category toModel) {
        Optional<WareHouse> byId = wareHouseDao.findById(toModel.getWareHouse().getId());
        if (byId.isEmpty()){
            throw new CustomException("WareHouseNotFound");
        }
        try{
            toModel.setWareHouse(byId.get());
            return categoryDao.save(toModel);
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public Category update(Category toModel) {
        WareHouse wareHouse = categoryDao.findById(toModel.getId()).orElseThrow().getWareHouse();
        try{
            toModel.setWareHouse(wareHouse);
            return categoryDao.save(toModel);
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public List<Category> getByWareHouseId(Integer id) {
        return categoryDao.findAllByWareHouseId(id);
    }
}
