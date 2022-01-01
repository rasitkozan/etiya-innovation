package com.innovation.orderservice.service;

import java.util.List;
import com.innovation.dto.OrderDto;

public interface IOrderService {

    void createOrder(OrderDto orderDto);
    void updateOrder(OrderDto orderDto);
    OrderDto getOrder(String orderId);
    void deleteOrder(String orderId);
    List<OrderDto> getAllOrder();
}
