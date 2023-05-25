package com.example.warehouse.mappers;

import com.example.warehouse.dtos.warehouse.WareHouseCreateDto;
import com.example.warehouse.dtos.warehouse.WareHouseShowDto;
import com.example.warehouse.dtos.warehouse.WareHouseUpdateDto;
import com.example.warehouse.entities.WareHouse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WareHouseMapper {

    WareHouseShowDto toDto(WareHouse wareHouse);

    WareHouse toModel(WareHouseCreateDto wareHouseCreateDto);

    WareHouse toModel(WareHouseUpdateDto wareHouseUpdateDto);
}
