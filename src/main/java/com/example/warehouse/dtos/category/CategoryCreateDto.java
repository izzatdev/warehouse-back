package com.example.warehouse.dtos.category;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDto {
    protected String name;
    private Integer wareHouseId;
}
