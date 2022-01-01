package com.innovation.customerservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;


@Table(value = "customer")
@Data
public class CustomerEntity implements Serializable {

  @PrimaryKey
  private String customerNumber = UUID.randomUUID().toString();

  @Column(value = "customer_name")
  private String customerName;

  @Column(value = "customer_type")
  private String customerType;

  @Column(value = "customer_email")
  private String customerEmail;

  @Column(value = "customer_password")
  private String customerPassword;
}
