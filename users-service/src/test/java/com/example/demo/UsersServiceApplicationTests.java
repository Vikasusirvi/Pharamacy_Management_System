package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class UsersServiceApplicationTests {

	@Autowired
	private UserService userService; 
	
	@MockBean
	private UserRepo userRepo;
	
	@Test
	public void getUsersTest() {
		
		when(userRepo.findAll()).thenReturn(Stream.of(new User((long)110,"vikas",(long)831035,"vikasusirvi1999@gmail.com","1234")).collect(Collectors.toList()));
		assertEquals(1, userService.findAll().size());
	}
	@Test
	public void saveUsersTest() {
		User user = new User((long)110,"vikas",(long)831035,"vikasusirvi1999@gmail.com","1234");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user,userService.saveUser(user));
	}
	@Test
	public void deleteUserTest() {
		userService.deleteUser((long)110);
		verify(userRepo,times(1)).deleteById((long)110);
	}
	
	
	
}
