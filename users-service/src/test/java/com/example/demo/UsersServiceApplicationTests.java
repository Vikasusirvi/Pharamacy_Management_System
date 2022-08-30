package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.controller.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class UsersServiceApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserController userController;

	@MockBean
	private UserRepository userRepo;

	@Test
	void getUsers() {
		when(userRepo.findAll())
				.thenReturn(Stream.of(new User((long) 11, "Nikhil", (long) 636124, "nikhil@gmail.com", "nik0609"))
						.collect(Collectors.toList()));
		Assertions.assertEquals(11, userService.findAll().size());
	}

	@Test
	void getUserController() {
		when(userRepo.findAll())
				.thenReturn(Stream.of(new User((long) 15, "Pavan", (long) 636124, "pavan@gmail.com", "pav0609"))
						.collect(Collectors.toList()));
		Assertions.assertEquals(15, userController.getUsers().size());
	}
	
	private void assertEquals(User user, User user2) {
		// TODO Auto-generated method stub

	}

	@Test
	void saveUser() {
		User user = new User((long) 11, "Nikhil", (long) 636124, "nikhil@gmail.com", "nik0609");
		when(userRepo.save(user)).thenReturn(user);
		Assertions.assertEquals(user, userService.saveUser(user));
	}

	@Test
	void saveUserController() {
		User user = new User((long) 12, "Pavan", (long) 636124, "pav@gmail.com", "nik0609");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userController.saveUser(user));
	}

	@Test
	void updateUser() {
		User user = new User((long) 12, "Vikas", (long) 7855554, "vikas@gmail.com", "vik0555S");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.updateUser(user));
	}

	@Test
	void updateUserController() {
		User user = new User((long) 13, "Kumuda", (long) 935854, "kumuda@gmail.com", "kum0555S");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userController.updateUser(user));
	}


	@Test
	void deleteUser() {
		userService.deleteUser((long) 11);
		verify(userRepo, times(1)).deleteById((long) 11);
	}

	@Test
	void testSetUserName() {
		User user = new User();
		user.setUserName("Nikhil");
		assertEquals(user.getUserName() == "Nikhil");
	}

	@Test
	void testSetUserPhoneNumber() {
		User user = new User();
		user.setUserPhoneNumber((long) 595898);
		assertEquals(user.getUserPhoneNumber() == 595898);
	}

	@Test
	void testSetUserEmail() {
		User user = new User();
		user.setUserEmail("nik@gmail.com");
		assertEquals(user.getUserEmail() == "nik@gmail.com");
	}

	@Test
	void testSetPassword() {
		User user = new User();
		user.setPassword("nik060920");
		assertEquals(user.getPassword() == "nik060920");
	}
	@Test
	void testSetUserID() {
		User user = new User();
		user.setUserID((long)65);
		assertEquals(user.getUserID() == 65);
	}
	private void assertEquals(boolean b) {
		// TODO Auto-generated method stub

	}
	@Test
	void testToString() {
		User user=new User((long) 13, "Kumuda", (long) 935854, "kumuda@gmail.com", "kum0555S");
		assertEquals(user.toString());
	}

	private void assertEquals(String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void deleteUserController() {
		userController.deleteUser((long) 12);
		verify(userRepo, times(1)).deleteById((long) 12);
	}
	
	
	
}
