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
import com.example.demo.entity.verificationToken;
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
	@GetMapping("/show")
	public List<Inventory> getInventory(){
		return inventoryService.findAll();		
	}
	@PostMapping("/update")
	public Inventory updateInventory(@RequestBody Inventory inventory) {
		int price = inventoryService.findInventory(inventory.getDrugID()).getDrugPrice()+inventory.getDrugPrice();
		int quantity = inventoryService.findInventory(inventory.getDrugID()).getDrugQuantity()+inventory.getDrugQuantity();
		inventory.setDrugPrice(price);
		inventory.setDrugQuantity(quantity);
		inventoryService.save(inventory);
		return inventory;
	}
	
	@RequestMapping("check/{drugID}/{drugQuantity}")
	public verificationToken checkInventory(@PathVariable("drugID") Long drugID, @PathVariable("drugQuantity") int drugQuantity) {
		
		Inventory inventory = inventoryService.findInventory(drugID);
		int inventoryPresent=inventory.getDrugQuantity();
		if(inventoryPresent >= drugQuantity) {
			int price = drugQuantity*inventory.getDrugPrice();
			inventory.setDrugQuantity(inventoryPresent-drugQuantity);
			inventoryService.updateInventory(inventory);
			verificationToken token = new verificationToken(price,true,drugQuantity);
			return token;
		}
		else {
		 verificationToken token = new verificationToken(0,false, drugQuantity);
		 return token;
		}
	}
	@DeleteMapping("/delete/{inventoryID}")
	public void deleteInventory(@PathVariable("inventoryID") Long inventoryID) {
		inventoryService.deleteInventory(inventoryID);
	}
}
