package com.innovation.orderservice.service.impl;

import com.innovation.client.ICustomerServiceClient;
import com.innovation.dto.CustomerDto;
import com.innovation.orderservice.mapper.OrderMapper;
import com.innovation.orderservice.repository.IOrderRepository;
import com.innovation.orderservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.innovation.dto.OrderDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final ICustomerServiceClient customerServiceClient;

    @Override
    public void createOrder(OrderDto orderDto) {
       ResponseEntity<CustomerDto> customerResponseEntity = customerServiceClient.getCustomer(orderDto.getCustomerId());
        if(ObjectUtils.equals(customerResponseEntity.getStatusCode(), HttpStatus.OK)){
            this.orderRepository.save(OrderMapper.INSTANCE.toEntity(orderDto));
        }
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        this.orderRepository.save(OrderMapper.INSTANCE.toEntity(orderDto));
    }

    @Override
    public OrderDto getOrder(String orderId) {
        return OrderMapper.INSTANCE.toDto(orderRepository.findById(orderId).orElse(null));
    }

    @Override
    public void deleteOrder(String orderId) {
       this.orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderDto> getAllOrder() {
       return OrderMapper.INSTANCE.toDto(this.orderRepository.findAll());
    }
}
