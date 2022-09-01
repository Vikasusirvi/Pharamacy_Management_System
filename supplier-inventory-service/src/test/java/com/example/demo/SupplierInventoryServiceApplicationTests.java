package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pharmacy.entity.Inventory;
import com.pharmacy.repository.InventoryRepo;
import com.pharmacy.service.InventoryService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SupplierInventoryServiceApplicationTests {

	@Autowired
	private InventoryService inventoryService;
	
	@MockBean
	private InventoryRepo inventoryRepo;
	
	@Test
	public void testSaveInventory() {
		Inventory inventory = new Inventory((long) 110 ,"azithromycilin", 1000,"MedCare");
		when(inventoryRepo.save(inventory)).thenReturn(inventory);
		assertEquals(inventory,inventoryService.save(inventory));
	}
	@Test
	public void testfindAll() {
		List<Inventory> inventorys = Stream.of(new Inventory((long) 110, "azithromicin", 1000,"MedCare"),new Inventory((long) 120, "awqwithromicin", 2000,"MedCare")).collect(Collectors.toList());
		when(inventoryRepo.findAll()).thenReturn(inventorys);
		assertEquals(2,inventoryService.findAll().size());
	}
	@Test
	public void testUpdateInventory() {
		Inventory inventory = new Inventory((long) 110 ,"azithromycilin", 1000,"MedCare");
		when(inventoryRepo.save(inventory)).thenReturn(inventory);
		assertEquals(inventory,inventoryService.updateInventory(inventory));
	}
	@Test
	public void testDeleteInventory() {
		inventoryService.deleteInventory((long)110);
		verify(inventoryRepo,times(1)).deleteById((long)110);
	}

}
