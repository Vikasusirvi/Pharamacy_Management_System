package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@RequestMapping("/helloWorld2")
	public String helloOrderService()
	{
		return "Hello-2";
	}

}
