package com.example.warehouse.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductShortInfo {
    private Integer id;
    private String name;
    private String description;
    private String supplierName;
    private String supplierContact;
}
