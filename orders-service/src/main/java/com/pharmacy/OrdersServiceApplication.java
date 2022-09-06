package com.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

import com.pharmacy.service.EmailSenderService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	@Autowired
	private EmailSenderService service;
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() {
		service.sendBill("nikhilcs2000m@gmail.com", "This is the emailbody", "This is subject");
	}
	
}
