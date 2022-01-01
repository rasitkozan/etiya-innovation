package com.innovation.orderservice.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "cust_ord")
public class OrderEntity {

  @Id
  private String orderId ;
  private boolean orderStatus;
  private String orderData;
  private String customerId;
}
