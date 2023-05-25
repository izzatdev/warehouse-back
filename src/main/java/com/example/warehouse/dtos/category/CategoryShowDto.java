package com.example.warehouse.dtos.category;

import com.example.warehouse.dtos.warehouse.WareHouseShowDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryShowDto extends CategoryUpdateDto {
    protected WareHouseShowDto wareHouse;
}
