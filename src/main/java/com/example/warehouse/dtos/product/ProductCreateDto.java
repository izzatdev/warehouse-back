package com.example.warehouse.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto extends ProductMainDto{
    protected Integer wareHouseId;
    protected Integer supplierId;
    protected Integer categoryId;
}
