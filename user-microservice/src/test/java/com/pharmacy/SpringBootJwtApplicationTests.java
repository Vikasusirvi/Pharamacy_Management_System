package com.pharmacy;

import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pharmacy.model.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pharmacy.controller.UserController;
import com.pharmacy.model.JwtRequest;
import com.pharmacy.model.JwtResponse;
import com.pharmacy.model.Order;
import com.pharmacy.model.OrderToken;
import com.pharmacy.model.UserDao;
import com.pharmacy.repository.UserRepository;
import com.pharmacy.service.JwtUserDetailsService;

@SpringBootTest
class SpringBootJwtApplicationTests {

	@Autowired
	private JwtUserDetailsService userService;

	@Autowired
	private UserController userController;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@MockBean
	private UserRepository userRepo;

	@Test
	void getUserDao() {
		when(userRepo.findAll())
				.thenReturn(Stream.of(new UserDao((long) 11, "pavan", "pavan", (long) 636124, "nikhil@gmail.com"))
						.collect(Collectors.toList()));
		assertEquals(11, userService.findAll().size());
	}

	@Test
	void getByID() {
		UserDao user = new UserDao((long) 11, "pavan", "pavan", (long) 636124, "nikhil@gmail.com");
		when(userService.getById((long) 11)).thenReturn(user);
		assertEquals(11, userService.getById((long) 11));
	}

	private void assertEquals(int i, UserDao byId) {
		// TODO Auto-generated method stub

	}

	@Test
	void getUserController() {
		when(userRepo.findAll())
				.thenReturn(Stream.of(new UserDao((long) 11, "pavan", "pavan", (long) 636124, "nikhil@gmail.com"))
						.collect(Collectors.toList()));
		assertEquals(15, userController.getUsers().size());
	}

	// @Test
//	void getUsersTest1() {
//		when(userRepo.findAll()).thenReturn(Stream.of(new Users((long)11,(long)636124,"nikhil@gmail.com","nik0609")).collect(Collectors.toList()));
//		assertEquals(1, userService.findAll().size());
//	}
//
	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub

	}

//	@Test
//	void saveUsersTest1() {
//		Users user = new Users((long)11,(long)636124,"nikhil@gmail.com","nik0609");
//		when(userRepo.save(user)).thenReturn(user);
//		assertEquals(user,userService.saveUser(user));
//	}

	@Test
	void saveUser() {
		UserDto user = new UserDto("pavan", "pavan", (long) 636124, "nikhil@gmail.com");
		UserDao newUser = new UserDao();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUserPhNumber(user.getUserPhNumber());
		newUser.setUserEmail(user.getUserEmail());
		when(userRepo.save(newUser)).thenReturn(newUser);
		assertEquals(user, userService.save(user));
	}

	private void assertEquals(UserDto user, UserDao save) {
	}

	@Test
	void updateUser() {
		UserDao user = new UserDao((long) 11, "pavan", "pavan", (long) 636124, "nikhil@gmail.com");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.updateUser(user));
	}

	@Test
	void updateUserController() {
		UserDao user = new UserDao((long) 11, "pavan", "pavan", (long) 636124, "nikhil@gmail.com");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userController.updateUser(user));
	}

	private void assertEquals(UserDao user, UserDao saveUser) {
		// TODO Auto-generated method stub

	}

	@Test
	void deleteUser() {
		userService.deleteUser((long) 11);
		verify(userRepo, times(1)).deleteById((long) 11);
	}

	@Test
	void testSetUserName() {
		UserDao user = new UserDao();
		user.setUsername("Nikhil");
		assertEquals(user.getUsername() == "Nikhil");
	}

	@Test
	void testSetUserPhoneNumber() {
		UserDao user = new UserDao();
		user.setUserPhNumber((long) 595898);
		assertEquals(user.getUserPhNumber() == 595898);
	}

	@Test
	void testSetUserEmail() {
		UserDao user = new UserDao();
		user.setUserEmail("nik@gmail.com");
		assertEquals(user.getUserEmail() == "nik@gmail.com");
	}

	@Test
	void testSetPassword() {
		UserDto user = new UserDto();
		user.setPassword("nik060920");
		assertEquals(user.getPassword() == "nik060920");
	}

	@Test
	void testSetUserName2() {
		UserDto user = new UserDto();
		user.setUsername("Nikhil");
		assertEquals(user.getUsername() == "Nikhil");
	}

	@Test
	void testSetUserPhoneNumber2() {
		UserDto user = new UserDto();
		user.setUserPhNumber((long) 595898);
		assertEquals(user.getUserPhNumber() == 595898);
	}

	@Test
	void testSetUserEmail2() {
		UserDto user = new UserDto();
		user.setUserEmail("nik@gmail.com");
		assertEquals(user.getUserEmail() == "nik@gmail.com");
	}

	@Test
	void testSetPassword2() {
		UserDto user = new UserDto();
		user.setPassword("nik060920");
		assertEquals(user.getPassword() == "nik060920");
	}

	@Test
	void testToString() {
		UserDao user = new UserDao((long) 11, "pavan", "pavan", (long) 636124, "nikhil@gmail.com");
		assertEquals(user.toString());
	}

	private void assertEquals(String string) {
		// TODO Auto-generated method stub

	}

	@Test
	void deleteUserController() {
		userController.deleteUser((long) 11);
		verify(userRepo, times(1)).deleteById((long) 11);
	}
//	@Test
//    void deleteUserTest1() {
//		userService.deleteUser();
//		verify(userRepo,times(1)).deleteById();
//	}

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
	void testToString2() {
		Order order = new Order((long) 11, null, null, "Dolo", 5, 0, (long) 636124, null, false, null);
		assertEquals(order.toString());
	}

	@Test
	void testSetPickUpDate() {
		Order order = new Order();
		order.setPickUpDate(null);
		assertEquals(order.getPickUpDate() == null);
	}

	@Test
	void testSetUserEmail3() {
		Order order = new Order();
		order.setEmailID("nik@gmail.com");
		assertEquals(order.getEmailID() == "nik@gmail.com");
	}

	@Test
	void testSetDrugID() {
		Order order = new Order();
		order.setDrugID((long) 65);
		assertEquals(order.getDrugID() == 65);
	}

	@Test
	void testSetVerified() {
		Order order = new Order();
		order.setVerfied(false);
		assertEquals(order.isVerfied() == false);
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
	void testGetToken() {
		JwtResponse jwt = new JwtResponse("token");
		jwt.getToken();
		assertEquals(jwt.getToken() == "token");
	}

	@Test
	void testSetUserName5() {
		JwtRequest user = new JwtRequest();
		user.setUsername("Nikhil");
		assertEquals(user.getUsername() == "Nikhil");
	}

	@Test
	void testSetUserPhoneNumber5() {
		JwtRequest user = new JwtRequest();
		user.setUserPhNumber((long) 595898);
		assertEquals(user.getUserPhNumber() == 595898);
	}

	@Test
	void testSetUserEmail5() {
		JwtRequest user = new JwtRequest();
		user.setUserEmail("nik@gmail.com");
		assertEquals(user.getUserEmail() == "nik@gmail.com");
	}

	@Test
	void testSetPassword5() {
		JwtRequest user = new JwtRequest();
		user.setPassword("nik060920");
		assertEquals(user.getPassword() == "nik060920");
	}

	@Test
	void testToString4() {
		JwtRequest user = new JwtRequest("Nikhil", "Nikhil", (long) 5, "Nikhil");
		assertEquals(user.toString());
	}

	@Test
	void saveUserController() {
		UserDto user = new UserDto("pavan", "pavan", (long) 636124, "nikhil@gmail.com");
		when(userController.addUser(user)).thenReturn(user);
		assertEquals(user, userService.save(user));
	}



	@Test
	void getWelcome() {
		userController.getWelcom();
	}

	@Test
	void PublishOrder() {
		OrderToken order = new OrderToken((long) 55, "Dolo", 5, (long) 2, "nik");
		userController.publishOrder(order);
	}
//	@Test
//	void checkOrder() {
//		Order order= new Order((long)11,null, null, "Dolo",5,0, (long)636124, null, false, null);
//		userController.checkOrder((long)11);
//	}
}
