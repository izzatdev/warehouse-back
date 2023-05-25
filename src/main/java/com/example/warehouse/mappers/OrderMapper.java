package com.example.warehouse.mappers;

import com.example.warehouse.dtos.orders.OrderShowDto;
import com.example.warehouse.dtos.product.ProductShortInfo;
import com.example.warehouse.entities.Order;
import com.example.warehouse.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "productShortInfo", source = "product", qualifiedByName = "getProductItem")
    @Mapping(target = "address", source = "shipment.address")
    @Mapping(target = "contact", source = "shipment.contact")
    @Mapping(target = "shippingDays", source = "shipment.shippingDays")
    OrderShowDto toDto(Order order);

    @Named("getProductItem")
    default ProductShortInfo getProductItem(Product product) {
        OrderShowDto orderShowDto = new OrderShowDto();
        ProductShortInfo res = new ProductShortInfo();
        res.setId(product.getId());
        res.setName(product.getName());
        res.setDescription(product.getDescription());
        res.setSupplierName(product.getSupplier().getName());
        res.setSupplierContact(product.getSupplier().getContact());
        return res;
    }


}
