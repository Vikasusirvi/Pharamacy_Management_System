package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@PostMapping("/save")
	public Inventory saveInventory(@RequestBody Inventory inventory) {
		
		logger.info("Inventory for {} with ID : {} and price: {} is saved with initial quantity of {} tabs supplied by {}"
				,inventory.getDrugName(),inventory.getDrugID(),inventory.getDrugPrice(),inventory.getDrugQuantity(),inventory.getSupplierName());
		
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
		
		logger.info("The inventory for {} with ID {} is updated",inventory.getDrugName(),inventory.getDrugID());
		
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
			logger.info("Order for {} has been satisfied for {} tabs and amount for the drugs is INR {} and the inventory has been updated for the {} drug to {} tabs",
					inventory.getDrugName(),drugQuantity,price,inventory.getDrugName(),inventory.getDrugQuantity());
			return token;
		}
		else {
		 verificationToken token = new verificationToken(0,false, drugQuantity);
		 return token;
		}
	}
	@DeleteMapping("/delete/{inventoryID}")
	public void deleteInventory(@PathVariable("inventoryID") Long inventoryID) {
		
		logger.info("The inventory with  DRUG ID {} is deleted.",inventoryID);
		
		inventoryService.deleteInventory(inventoryID);
	}
}
