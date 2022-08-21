package com.example.SupplierInventoryMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SupplierInventoryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierInventoryMsApplication.class, args);
	}

}
