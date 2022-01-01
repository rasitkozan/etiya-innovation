package com.innovation.customerservice.mapper;

import com.innovation.customerservice.entity.CustomerEntity;
import com.innovation.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  CustomerDto toDto(CustomerEntity customerEntity);
  List<CustomerDto> toDto(List<CustomerEntity> customerEntityList);
  CustomerEntity toEntity(CustomerDto customerDto);
  List<CustomerEntity> toEntity(List<CustomerDto> customerDtoList);
}
