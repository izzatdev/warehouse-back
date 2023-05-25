package com.example.warehouse.dtos.category;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateDto extends CategoryCreateDto {
    protected Integer id;
}
