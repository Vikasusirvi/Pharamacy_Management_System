package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	static Logger logger = LoggerFactory.getLogger(ApiGatewayApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		
		logger.info("API GATEWAY IS UP AND RUNNING");
	}

}
