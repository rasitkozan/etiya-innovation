package com.innovation.customerservice.controller;


import com.innovation.customerservice.service.ICustomerService;
import com.innovation.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

  final ICustomerService customerService;

  @PostMapping("/create")
  public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto) {
    customerService.createCustomer(customerDto);
    return ResponseEntity.ok("Created");
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable String customerId) {

    CustomerDto customerDto = customerService.getCustomer(customerId);
    if (Objects.isNull(customerDto)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customerDto);
  }

  @PutMapping("/update")
  public ResponseEntity<String> updateCustomer(@RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(customerDto);
    return ResponseEntity.ok("Updated");
  }

  @DeleteMapping("/{customerId}")
  public ResponseEntity<String> deleteCustomer(@PathVariable String customerId) {
    customerService.deleteCustomer(customerId);
    return ResponseEntity.ok("Deleted");
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<CustomerDto>> getAllCustomer() {
    return ResponseEntity.ok(customerService.getAllCustomer());
  }

}
