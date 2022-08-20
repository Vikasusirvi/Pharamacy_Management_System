package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierInventoryController {
	@RequestMapping("/helloWorld3")
	public String helloSupplierService()
	{
		return "Hello-3";
	}

}
