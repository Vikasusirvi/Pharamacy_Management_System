package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {

}
