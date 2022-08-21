package com.example.SupplierInventoryMS.controller;

import com.example.SupplierInventoryMS.entity.Inventory;
import com.example.SupplierInventoryMS.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
