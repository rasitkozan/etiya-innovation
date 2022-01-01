package com.innovation.dto;

import lombok.Data;

@Data
public class OrderDto {
  private String orderId ;
  private boolean orderStatus;
  private String orderData;
  private String customerId;
}
