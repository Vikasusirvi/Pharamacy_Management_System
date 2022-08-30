package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		
		userRepo.save(user);
		return user;
	}
	public List<User> findAll(){
		
		return userRepo.findAll();
	}
	public void deleteUser(Long userID) {
		userRepo.deleteById(userID);
	}
	public User updateUser(User user)   
	{  
	userRepo.save(user);  
	return user;
	}
}
