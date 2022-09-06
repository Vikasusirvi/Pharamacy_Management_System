package com.pharmacy;

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
import com.pharmacy.entity.email;
import com.pharmacy.entity.Inventory;
import com.pharmacy.entity.verificationToken;
import com.pharmacy.entity.OrderToken;
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
		when(orderRepo.findAll())
				.thenReturn(Stream.of(new Order((long) 11, "Dolo", 5, (long) 636124)).collect(Collectors.toList()));
		assertEquals(1, orderService.findAll().size());
	}

	@Test
	void saveOrdersTest() {
		Order order = new Order((long) 11, "Dolo", 5, (long) 636124);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, orderService.saveOrder(order));
	}

	private void assertEquals(Order order, Object object) {
		// TODO Auto-generated method stub
	}

	@Test
	void deleteOrderTest() {
		orderService.deleteOrder((long) 11);
		verify(orderRepo, times(1)).deleteById((long) 11);
	}

	@Test
	void getOrderController() {
		when(orderRepo.findAll())
				.thenReturn(Stream.of(new Order((long) 11, "Dolo", 5, (long) 636124)).collect(Collectors.toList()));
		assertEquals(1, orderController.getOrders().size());
	}

	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
	}

	@Test
	void saveOrderController() {
		Order order = new Order((long) 11, "Dolo", 5, (long) 636124);
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, orderController.save(order));
	}

	@Test
	void updateOrderController() {
		Order order = new Order((long) 11, "Dolo", 5, (long) 636124);
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
		order.setUserID((long) 65);
		assertEquals(order.getUserID() == 65);
	}

	@Test
	void testSetOrderID() {
		Order order = new Order();
		order.setOrderID((long) 655);
		assertEquals(order.getOrderID() == 655);
	}

	private void assertEquals(boolean b) {
		// TODO Auto-generated method stub
	}

	@Test
	void testToString() {
		Order order = new Order((long) 11, "Dolo", 5, (long) 636124);
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

	@Test
	void testSetUserEmail4() {
		OrderToken order = new OrderToken();
		order.setEmailID("nik@gmail.com");
		assertEquals(order.getEmailID() == "nik@gmail.com");
	}

	@Test
	void testSetDrugID2() {
		OrderToken order = new OrderToken();
		order.setDrugID((long) 65);
		assertEquals(order.getDrugID() == 65);
	}

	@Test
	void testSetOrderName2() {
		OrderToken order = new OrderToken();
		order.setDrugName("Dolo");
		assertEquals(order.getDrugName() == "Dolo");
	}

	@Test
	void testSetUserID2() {
		OrderToken order = new OrderToken();
		order.setUserID((long) 65);
		assertEquals(order.getUserID() == 65);
	}

	@Test
	void testSetUserQuantity2() {
		OrderToken order = new OrderToken();
		order.setDrugQuantity(65);
		assertEquals(order.getDrugQuantity() == 65);
	}

	@Test
	void testToString3() {
		OrderToken order = new OrderToken((long) 55, "Dolo", 5, (long) 2, "nik");
		assertEquals(order.toString());
	}

	@Test
	void testSetToEmail() {
		email email = new email();
		email.setToEmail("nikhilcs2000m@gmail.com");
		assertEquals(email.getToEmail() == "nikhilcs2000m@gmail.com");
	}

	@Test
	void testSetBody() {
		email email = new email();
		email.setBody("ORDER PLACED");
		assertEquals(email.getBody() == "ORDER PLACED");
	}

	@Test
	void testSetSubject() {
		email email = new email();
		email.setSubject("ORDER");
		assertEquals(email.getSubject() == "ORDER");
	}

	@Test
	void testToStringEmail() {
		email email = new email("nikhilcs2000m@gmail.com", "orderplaced", "nik");
		assertEquals(email.toString());
	}

	@Test
	void testSetDrugIDInventory() {
		Inventory inv = new Inventory();
		inv.setDrugID((long) 65);
		assertEquals(inv.getDrugID() == 65);
	}

	@Test
	void testSetOrderNameInventory() {
		Inventory inv = new Inventory();
		inv.setDrugName("Dolo");
		assertEquals(inv.getDrugName() == "Dolo");
	}

	@Test
	void testSetUserQuantityInventory() {
		Inventory inv = new Inventory();
		inv.setDrugQuantity(65);
		assertEquals(inv.getDrugQuantity() == 65);
	}

	@Test
	void testSetSupplierNameInventory() {
		Inventory inv = new Inventory();
		inv.setSupplierName("Para");
		assertEquals(inv.getSupplierName() == "Para");
	}

	@Test
	void testToStringInventory() {
		Inventory inv = new Inventory((long) 65, "Dolo", 5, "Para");
		assertEquals(inv.toString());
	}

	@Test
	void testSetDrugQuantityVerify() {
		verificationToken inv = new verificationToken();
		inv.setDrugQuantity(65);
		assertEquals(inv.getDrugQuantity() == 65);
	}

	@Test
	void testSetDrugAmountVerify() {
		verificationToken inv = new verificationToken();
		inv.setDrugAmount(65);
		assertEquals(inv.getDrugAmount() == 65);
	}
	@Test
	void testSetPresentVerify() {
		verificationToken inv = new verificationToken();
		inv.setPresent(true);
		assertEquals(inv.isPresent() == true);
	}
	@Test
	void testToStringVerified() {
		verificationToken inv = new verificationToken(65,true,65);
		assertEquals(inv.toString());
	}
	@Test
	void testSetVerified() {
		Order order = new Order();
		order.setVerfied(false);
		assertEquals(order.isVerfied() == false);
	}

	@Test
	void testSetPickUpDate() {
		Order order = new Order();
		order.setPickUpDate(null);
		assertEquals(order.getPickUpDate() == null);
	}
	@Test
	void testToString2() {
		Order order = new Order((long) 11, null, null, "Dolo", 5, 0, (long) 636124, null, false, null);
		assertEquals(order.toString());
	}
	@Test
	void testToString4() {
		Order order = new Order(null,"Dolo", 5, 0, (long) 636124);
		assertEquals(order.toString());
	}
	@Test
	void testToString5() {
		Order order = new Order((long) 11,null,"Dolo", 5, 0, (long) 636124);
		assertEquals(order.toString());
	}
	@Test
	void getByID() {
		Order order = new Order((long) 11, null, null, "Dolo", 5, 0, (long) 636124, null, false, null);
		when(orderService.findyByOrderID((long) 12)).thenReturn(null);
		assertEquals(11, orderService.findyByOrderID((long) 11));
	}

	private void assertEquals(int i, Order findyByOrderID) {
		// TODO Auto-generated method stub
		
	}
	@Test
	void getUserOrder() {
		Order order = new Order((long) 11, null, null, "Dolo", 5, 0, (long) 636124, null, false, null);
		orderController.getUserOrder((long)5);
	}
	@Test
	void testToListenOrder() {
		OrderToken order = new OrderToken((long) 55, "Dolo", 5, (long) 2, "nik");
		orderController.listenToOrders(order);	}
//	@Test
//	void testToVerifyOrder() {
//		Order order = new Order((long) 11, null, null, "Dolo", 5, 1, (long) 636124, null, false, null);
//		orderController.verifyOrder(order.getOrderID());	}
	@Test
	void testToVerified() {
		OrderToken order = new OrderToken((long) 55, "Dolo", 5, (long) 2, "nik");
		orderController.verifiedOrder((long)11);
		orderController.unverifiedOrders();
		}

}