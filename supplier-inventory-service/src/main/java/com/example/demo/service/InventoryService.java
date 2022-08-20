package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepo;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;
	
	public Inventory save(Inventory inventory) {
		inventoryRepo.save(inventory);
		return inventory;
	}
	public List<Inventory> findAll(){
		return inventoryRepo.findAll();
	}
	public Inventory updateInventory(Inventory inventory) {
		inventoryRepo.save(inventory);
		return inventory;
	}
	public void deleteInventory(Long inventoryID) {
		inventoryRepo.deleteById(inventoryID);
	}
	
}
