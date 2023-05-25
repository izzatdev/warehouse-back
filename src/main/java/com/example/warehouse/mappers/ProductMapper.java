package com.example.warehouse.mappers;

import com.example.warehouse.dtos.product.ProductMainDto;
import com.example.warehouse.entities.Product;
import com.example.warehouse.entities.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import static com.example.warehouse.entities.Product.Currency;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "currency", source = "currency", qualifiedByName = "getCurrency")
    @Mapping(target = "quantity", source = "stock", qualifiedByName = "getQuantity")
    ProductMainDto toDto(Product product);


    @Named("getCurrency")
    default String getCurrency(Currency  cur) {
        return cur.name();
    }

    @Named("getQuantity")
    default double getQuantity(Stock stock) {
        return stock.getQuantity();
    }
}
