package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepo;
import com.example.demo.service.OrderService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrdersServiceApplicationTests {

	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepo orderRepo;
	
	@Test
	public void testSaveOrder() {
		Order order = new Order((long) 110,(long) 1203200,"Azithromycin", 100, 23, (long) 1234);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order,orderService.saveOrder(order));
	}
	@Test
	public void testFindAll() {
		List<Order> orders = Stream.of(new Order((long) 110,(long) 1203200,"Azithromycin", 100, 23, (long) 1234),
				new Order((long) 120,(long) 1303200,"Paracetamol", 200, 15, (long) 1234)).collect(Collectors.toList());
		when(orderRepo.findAll()).thenReturn(orders);
		assertEquals(orders,orderService.findAll());
	}
}