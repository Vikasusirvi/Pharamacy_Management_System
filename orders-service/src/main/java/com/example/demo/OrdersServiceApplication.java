package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.EmailSenderService;

@SpringBootApplication
public class OrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	@Autowired
	private EmailSenderService service;
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() {
		service.sendBill("vikasusirvi1999@gmail.com", "This is the emailbody", "This is subject");
	}
	
	
	
}
