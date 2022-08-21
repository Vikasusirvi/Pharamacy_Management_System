package com.example.UserMS;

import com.example.UserMS.Entity.User;
import com.example.UserMS.Repository.UserRepo;
import com.example.UserMS.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserMsApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepo userRepo;

	@Test
	public void getUsersTest() {

		when(userRepo.findAll()).thenReturn(Stream.of(new User((long)1001,"Kumuda",(long)899035,"ksiritt@gmail.com","Kumu123")).collect(Collectors.toList()));
		assertEquals(1, userService.findAll().size());
	}
	@Test
	public void saveUsersTest() {
		User user = new User((long)1001,"Kumuda",(long)899035,"ksiritt@gmail.com","Kumu123");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user,userService.saveUser(user));
	}
	@Test
	public void deleteUserTest() {
		userService.deleteUser((long)1001);
		verify(userRepo,times(1)).deleteById((long)1001);
	}

}
