package com.example.demo.controller;

//import java.net.URI;
import java.util.List;

//import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
//import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;*/
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderToken;
import com.example.demo.entity.User;
import com.example.demo.entity.mqConfig;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RabbitTemplate template;
	
	@RequestMapping("/order")
	public String publishOrder(@RequestBody OrderToken token) {
		
		template.convertAndSend(mqConfig.EXCHANGE, mqConfig.ROUTING_KEY, token);
		return "Order Published";
	}
	@RequestMapping("/check/{orderID}")
	public Order checkOrder(@PathVariable("orderID") Long orderID ) {
		
		Order order = restTemplate.getForObject("http://order-service/order/check/"+orderID, Order.class);
		return order;	
	}
	@PostMapping("/save")
	public User saveUser(@RequestBody User user ) {
		userService.saveUser(user);
		return user;
	}
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.findAll();
	}
	@DeleteMapping("/delete/{userID}")
	public void deleteUser(@PathVariable("userID") Long userID) {
		userService.deleteUser(userID);
	}
	@PutMapping("/update")  
	public User updateUser(@RequestBody User user)   
	{  
	userService.updateUser(user);  
	return user;  
	} 
}
