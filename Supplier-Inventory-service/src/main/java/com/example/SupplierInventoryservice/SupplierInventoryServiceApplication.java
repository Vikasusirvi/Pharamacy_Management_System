package com.example.SupplierInventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SupplierInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierInventoryServiceApplication.class, args);
	}

}
