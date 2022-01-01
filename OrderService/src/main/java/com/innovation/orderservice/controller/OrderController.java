package com.innovation.orderservice.controller;

import com.innovation.dto.OrderDto;
import com.innovation.orderservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

  final IOrderService orderService;

  @PostMapping("/create")
  public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
    orderService.createOrder(orderDto);
    return ResponseEntity.ok("Created");
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderDto> getOrder(@PathVariable String orderId) {

    OrderDto orderDto = orderService.getOrder(orderId);
    if (Objects.isNull(orderDto)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(orderDto);
  }

  @PutMapping("/update")
  public ResponseEntity<String> updateOrder(@RequestBody OrderDto orderDto) {
    orderService.updateOrder(orderDto);
    return ResponseEntity.ok("Updated");
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<String> deleteOrder(@PathVariable String orderId) {
    orderService.deleteOrder(orderId);
    return ResponseEntity.ok("Deleted");
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<OrderDto>> getAllOrder() {
    return ResponseEntity.ok(orderService.getAllOrder());
  }

}
