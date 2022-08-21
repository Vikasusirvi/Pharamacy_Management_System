package com.example.SupplierInventoryMS.service;

import com.example.SupplierInventoryMS.entity.Inventory;
import com.example.SupplierInventoryMS.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteInventory(Long inventoryID) {

        inventoryRepo.deleteById(inventoryID);
    }
}
