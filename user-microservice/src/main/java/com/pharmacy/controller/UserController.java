package com.pharmacy.controller;
import java.util.List;
import java.util.Optional;

import com.pharmacy.config.mqConfig;
//import com.pharmacy.config.mqConfig;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.pharmacy.model.Order;
import com.pharmacy.model.OrderToken;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pharmacy.model.UserDao;
import com.pharmacy.model.UserDto;
import com.pharmacy.service.JwtUserDetailsService;
@RestController
@CrossOrigin()
public class UserController {


	@Autowired
	private RabbitTemplate template;
	@Autowired
	private JwtUserDetailsService userService;
	@Autowired
	private RestTemplate restTemplate;
	
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getWelcom() {
        return "Welcome to Pharmacy!";
    }
 
	@GetMapping("/users")
	public List<UserDao> getUsers(){
		return userService.findAll();
	}

	@DeleteMapping("/delete/{userID}")
	public void deleteUser(@PathVariable("userID") Long userID) {
		userService.deleteUser(userID);
	}

	@PutMapping("/update")  
	public UserDao updateUser(@RequestBody UserDao user)   
	{  
	userService.updateUser(user);  
	return user;  
	} 
	@PostMapping("/add")  
	public UserDto addUser(@RequestBody UserDto user)   
	{  
	userService.save(user);  
	return user;
	}
	@RequestMapping("/email/{userID}")
	public String sendEmail(@PathVariable("userID") Long userID) {
		UserDao user1=userService.getById(userID);
		String email = user1.getUserEmail();
		return email;
	}

	@RequestMapping("/order")
	public String publishOrder(@RequestBody OrderToken token) {

		template.convertAndSend(mqConfig.EXCHANGE, mqConfig.ROUTING_KEY, token);
		return "Order Published";
	}
	@RequestMapping("/check/{orderID}")
	public Order checkOrder(@PathVariable("orderID") Long orderID ) {

		Order order = restTemplate.getForObject("http://localhost:8082/order/check/"+orderID, Order.class);
		return order;
	}
    
}