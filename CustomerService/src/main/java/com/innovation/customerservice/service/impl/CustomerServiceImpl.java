package com.innovation.customerservice.service.impl;

import com.innovation.customerservice.mapper.CustomerMapper;
import com.innovation.customerservice.repository.ICustomerRepository;
import com.innovation.customerservice.service.ICustomerService;
import com.innovation.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerDto customerDto) {

        this.customerRepository.save(CustomerMapper.INSTANCE.toEntity(customerDto));
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        this.customerRepository.save(CustomerMapper.INSTANCE.toEntity(customerDto));
    }

    @Override
    public CustomerDto getCustomer(String customerId) {
        return CustomerMapper.INSTANCE.toDto(customerRepository.findByCustomerNumber(customerId));
    }

    @Override
    public void deleteCustomer(String customerId) {
        this.customerRepository.deleteCustomerEntityByCustomerNumber(customerId);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return CustomerMapper.INSTANCE.toDto(this.customerRepository.findAll());
    }
}
