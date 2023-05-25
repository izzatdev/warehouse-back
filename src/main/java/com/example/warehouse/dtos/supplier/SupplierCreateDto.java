package com.example.warehouse.dtos.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierCreateDto {
    protected String name;
    protected String address;
    protected String contact;
}
