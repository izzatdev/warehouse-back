package com.example.warehouse.dtos.warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseCreateDto {
    protected String name;
    protected String location;
    protected double capacity;
}
