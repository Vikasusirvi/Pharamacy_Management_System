package com.example.Userservice.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/hello1")
	public String helloUser() {
		return "Hello World 1";
	}
}
