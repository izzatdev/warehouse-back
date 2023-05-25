package com.example.warehouse.mappers;

import com.example.warehouse.dtos.category.CategoryCreateDto;
import com.example.warehouse.dtos.category.CategoryShowDto;
import com.example.warehouse.dtos.category.CategoryUpdateDto;
import com.example.warehouse.entities.Category;
import com.example.warehouse.entities.WareHouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {WareHouseMapper.class})
public interface CategoryMapper {
    Category toModel(CategoryUpdateDto categoryUpdateDto);

    @Mapping(target = "wareHouse", source = "wareHouseId", qualifiedByName = "creatWareHouse")
    Category toModel(CategoryCreateDto categoryCreateDto);

    CategoryShowDto toDto(Category category);

    @Named("creatWareHouse")
    default WareHouse creatWareHouse(Integer id) {
        return WareHouse.builder().id(id).build();
    }
}