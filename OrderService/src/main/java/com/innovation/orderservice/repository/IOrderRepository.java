package com.innovation.orderservice.repository;

import com.innovation.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository  extends JpaRepository<OrderEntity, String> {

}
