package com.example.warehouse.services.impls;

import com.example.warehouse.dtos.product.ProductCreateDto;
import com.example.warehouse.dtos.product.ProductUpdateDto;
import com.example.warehouse.entities.*;
import com.example.warehouse.entities.Product.Currency;
import com.example.warehouse.repository.*;
import com.example.warehouse.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final SupplierDao supplierDao;
    private final WareHouseDao wareHouseDao;
    private final StockDao stockDao;
    private final CategoryDao categoryDao;

    @Override
    public Product create(ProductCreateDto productCreateDto) {
        return createOrUpdate(productCreateDto, null);
    }

    @Override
    public Product update(ProductUpdateDto productUpdateDto) {
        return createOrUpdate(productUpdateDto, productUpdateDto.getId());
    }

    @Override
    public Product getById(Integer id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> getByCategoryId(Integer id) {
        return productDao.getProductsByCategoryId(id);
    }

    @Override
    public List<Product> getBySupplierId(Integer id) {
        return productDao.getProductsBySupplierId(id);
    }

    @Transactional
    Product createOrUpdate(ProductCreateDto productCreateDto, Integer productId) {
        Product product = Product.builder()
                .id(productId)
                .description(productCreateDto.getDescription())
                .name(productCreateDto.getName())
                .price(productCreateDto.getPrice())
                .unit(productCreateDto.getUnit())
                .value(productCreateDto.getValue())
                .currency(Currency.valueOf(productCreateDto.getCurrency().toUpperCase()))
                .build();
        Supplier supplier = supplierDao.findById(productCreateDto.getSupplierId()).orElseThrow();
        product.setSupplier(supplier);
        Category category = categoryDao.findById(productCreateDto.getCategoryId()).orElseThrow();
        product.setCategory(category);
        WareHouse wareHouse = wareHouseDao.findById(productCreateDto.getWareHouseId()).orElseThrow();
        Product saved = productDao.save(product);
        Stock stock = new Stock();
        if (productId != null) {
            stock = productDao.findById(product.getId()).orElseThrow().getStock();
        }
        stock.setWareHouse(wareHouse);
        stock.setQuantity(productCreateDto.getQuantity());
        stock.setProduct(saved);
        saved.setStock(stockDao.save(stock));
        return productDao.save(saved);
    }
}
