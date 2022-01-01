package com.innovation.client;

import com.innovation.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("CustomerService")
public interface ICustomerServiceClient {

  @RequestMapping("/customer/{customerId}")
  ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") String customerId);
}
