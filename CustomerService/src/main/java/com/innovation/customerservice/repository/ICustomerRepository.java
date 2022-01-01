package com.innovation.customerservice.repository;

import com.innovation.customerservice.entity.CustomerEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CassandraRepository<CustomerEntity,Long> {
  CustomerEntity findByCustomerNumber(String customerId);
  void deleteCustomerEntityByCustomerNumber(String customerId);
}
