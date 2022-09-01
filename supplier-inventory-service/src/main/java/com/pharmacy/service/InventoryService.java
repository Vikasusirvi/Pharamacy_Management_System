package com.pharmacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.entity.Inventory;
import com.pharmacy.repository.InventoryRepo;

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
	public Inventory findInventory(Long drugID) {
		Optional<Inventory> inventory = inventoryRepo.findById(drugID);
		if (inventory.isPresent()) {
			return inventory.get();
		}
		return null;
	}
}
