package com.example.warehouse.dtos.orders;

import com.example.warehouse.dtos.product.ProductShortInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderShowDto extends OrderCreateDto {
    private Integer id;
    private ProductShortInfo productShortInfo;
}
