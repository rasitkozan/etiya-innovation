package com.innovation.orderservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.innovation")
@EnableJpaRepositories("com.innovation")
public class OrderConfiguration  {

}
