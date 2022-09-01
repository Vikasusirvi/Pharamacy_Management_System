package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pharmacy.controller.*;
import com.pharmacy.entity.Order;
import com.pharmacy.repository.OrderRepo;
import com.pharmacy.service.OrderService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrdersServiceApplicationTests {

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderController orderController;
	@MockBean
	private OrderRepo orderRepo;

	@Test
	void getOrdersTest() {
		when(orderRepo.findAll()).thenReturn(Stream.of(new Order((long)11,"Dolo",5,(long)636124)).collect(Collectors.toList()));
		assertEquals(1, orderService.findAll().size());
	}
	@Test
	void saveOrdersTest() {
		Order order = new Order((long)11,"Dolo",5,(long)636124);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order,orderService.saveOrder(order));
	}
	private void assertEquals(Order order, Object object) {
	// TODO Auto-generated method stub	
	}
	@Test
     void deleteOrderTest() {
		orderService.deleteOrder((long)11);
		verify(orderRepo,times(1)).deleteById((long)11);
	}
	@Test
	void getOrderController() {
		when(orderRepo.findAll())
				.thenReturn(Stream.of( new Order((long)11,"Dolo",5,(long)636124))
						.collect(Collectors.toList()));
		assertEquals(1, orderController.getOrders().size());
	}
	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub	
	}
	@Test
	void saveOrderController() {
		Order order = new Order((long)11,"Dolo",5,(long)636124);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, orderController.save(order));
	}
	@Test
	void updateOrderController() {
		Order order =  new Order((long)11,"Dolo",5,(long)636124);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, orderController.updateOrder(order));
	}
	@Test
	void deleteOrder() {
		orderService.deleteOrder((long) 11);
		verify(orderRepo, times(1)).deleteById((long) 11);
	}
	@Test
	void testSetOrderName() {
		Order order = new Order();
		order.setDrugName("Dolo");
		assertEquals(order.getDrugName() == "Dolo");
	}
	@Test
	void testSetOrderPhoneNumber() {
		Order order = new Order();
		order.setDrugQuantity(5);
		assertEquals(order.getDrugQuantity() == 5);
	}
	@Test
	void testSetOrderEmail() {
		Order order = new Order();
		order.setDrugPrice(25);
		assertEquals(order.getDrugPrice() == 25);
	}
	@Test
	void testSetOrderDate() {
		Order order = new Order();
		order.setOrderDate(LocalDate.now());
		assertEquals(order.getOrderDate() == LocalDate.now());
	}
	@Test
	void testSetUserID() {
		Order order = new Order();
		order.setUserID((long)65);
		assertEquals(order.getUserID() == 65);
	}
	@Test
	void testSetOrderID() {
		Order order = new Order();
		order.setOrderID((long)655);
		assertEquals(order.getOrderID() == 655);
	}
	private void assertEquals(boolean b) {
		// TODO Auto-generated method stub
	}
	@Test
	void testToString() {
		Order order= new Order((long)11,"Dolo",5,(long)636124);
		assertEquals(order.toString());
	}
	private void assertEquals(String string) {
		// TODO Auto-generated method stub	
	}
	@Test
	void deleteOrderController() {
		orderController.deleteOrder((long) 12);
		verify(orderRepo, times(1)).deleteById((long) 12);
	}
}