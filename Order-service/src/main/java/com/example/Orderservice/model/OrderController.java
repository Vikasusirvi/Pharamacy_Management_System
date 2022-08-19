package com.example.Orderservice.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@RequestMapping("/hello2")
	public String helloOrder() {
		return "Hello World 2";
	}

}
