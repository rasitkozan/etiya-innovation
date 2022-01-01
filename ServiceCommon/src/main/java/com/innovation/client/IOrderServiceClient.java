package com.innovation.client;

import com.innovation.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("OrderService")
public interface IOrderServiceClient {

  @RequestMapping("/order/{orderId}")
  ResponseEntity<OrderDto> getOrder(@PathVariable("orderId") String orderId);
}
