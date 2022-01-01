package com.innovation.customerservice.service;

import com.innovation.dto.CustomerDto;

import java.util.List;

public interface ICustomerService {

    void createCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDto customerDto);
    CustomerDto getCustomer(String customerId);
    void deleteCustomer(String customerId);
    List<CustomerDto> getAllCustomer();
}
