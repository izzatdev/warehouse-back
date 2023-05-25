package com.example.warehouse.mappers;

import com.example.warehouse.dtos.supplier.SupplierCreateDto;
import com.example.warehouse.dtos.supplier.SupplierShowDto;
import com.example.warehouse.dtos.supplier.SupplierUpdateDto;
import com.example.warehouse.entities.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SupplierMapper {
    SupplierShowDto toDto(Supplier supplier);

    Supplier toModel(SupplierCreateDto supplierCreateDto);

    Supplier toModel(SupplierUpdateDto supplierUpdateDto);
}
