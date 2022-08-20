package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Inventory;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/save")
	public Inventory saveInventory(@RequestBody Inventory inventory) {
		return inventoryService.save(inventory);
	}
	@GetMapping("/inventory")
	public List<Inventory> getInventory(){
		return inventoryService.findAll();		
	}
	@PostMapping("/update")
	public Inventory updateInventory(@RequestBody Inventory inventory) {
		inventoryService.save(inventory);
		return inventory;
	}
	@DeleteMapping("/delete/{inventoryID}")
	public void deleteInventory(@PathVariable("inventoryID") Long inventoryID) {
		inventoryService.deleteInventory(inventoryID);
	}
}
