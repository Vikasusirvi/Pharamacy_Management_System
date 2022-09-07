package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoverServiceApplication {

	static Logger logger = LoggerFactory.getLogger(DiscoverServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DiscoverServiceApplication.class, args);
		
		logger.info("DISCOVER SERVICE IS UP AND RUNNING ");
	}
}
