package com.example.warehouse.services.impls;

import com.example.warehouse.repository.WareHouseDao;
import com.example.warehouse.entities.WareHouse;
import com.example.warehouse.exceptions.CustomException;
import com.example.warehouse.services.WareHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WareHouseServiceImpl implements WareHouseService {
    private final WareHouseDao wareHouseDao;
    @Override
    public List<WareHouse> getAll() {
        return wareHouseDao.findAll();
    }

    @Override
    public WareHouse create(WareHouse wareHouse) {
        try{
            return wareHouseDao.save(wareHouse);
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public WareHouse update(WareHouse wareHouse) {
        try{
            return wareHouseDao.saveAndFlush(wareHouse);
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public WareHouse getById(Integer id) {
        return wareHouseDao.findById(id).orElse(null);
    }
}
