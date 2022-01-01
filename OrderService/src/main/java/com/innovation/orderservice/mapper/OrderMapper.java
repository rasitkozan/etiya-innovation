package com.innovation.orderservice.mapper;

import com.innovation.orderservice.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.innovation.dto.OrderDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  OrderDto toDto(OrderEntity orderEntity);
  List<OrderDto> toDto(List<OrderEntity> orderEntityList);
  OrderEntity toEntity(OrderDto orderDto);
  List<OrderEntity> toEntity(List<OrderDto> orderDtoList);
}
