package com.example.warehouse.services.impls;

import com.example.warehouse.entities.Product;
import com.example.warehouse.entities.Supplier;
import com.example.warehouse.exceptions.CustomException;
import com.example.warehouse.repository.SupplierDao;
import com.example.warehouse.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierDao supplierDao;

    @Override
    public Supplier getById(Integer id) {
        return supplierDao.findById(id).orElse(null);
    }

    @Override
    public Supplier create(Supplier toModel) {
        try {
            return supplierDao.save(toModel);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public Supplier update(Supplier toModel) {
        Set<Product> products = supplierDao.findById(toModel.getId()).orElseThrow().getProducts();
        try {
            toModel.setProducts(products);
            return supplierDao.save(toModel);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDao.findAll();
    }
}
