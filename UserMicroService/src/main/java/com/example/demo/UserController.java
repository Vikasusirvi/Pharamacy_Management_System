package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping("/helloWorld1")
	public String helloUserService() {
		return "Hello-1";
	}
	

}