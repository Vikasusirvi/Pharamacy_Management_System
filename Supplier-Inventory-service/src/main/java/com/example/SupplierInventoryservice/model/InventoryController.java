package com.example.SupplierInventoryservice.model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  InventoryController {
	
	@RequestMapping("/hello3")
	public String hello() {
		return "Hello World 3";
	}
}

