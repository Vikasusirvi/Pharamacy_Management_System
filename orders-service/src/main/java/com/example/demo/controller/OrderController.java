package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.mqConfig;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderToken;
import com.example.demo.entity.SMS;
import com.example.demo.entity.email;
import com.example.demo.entity.verificationToken;
//import com.example.demo.service.EmailSenderService;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService; 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RabbitTemplate template;
	
	
	//private EmailSenderService emailSenderService;
	
	@RequestMapping("/receive")
	public Order save(@RequestBody Order order) {
		
		Order rOrder = new Order();
		rOrder.setVerfied(false);
		LocalDate d = LocalDate.now();
		rOrder.setOrderDate(d);
		rOrder.setDrugQuantity(order.getDrugQuantity());
		rOrder.setDrugPrice(00);
		rOrder.setDrugID(order.getDrugID());
		rOrder.setDrugName(order.getDrugName());
		rOrder.setOrderID(order.getOrderID());
		rOrder.setPickUpDate(null);
		rOrder.setUserID(order.getUserID());
		orderService.saveOrder(rOrder);
		return rOrder;
	}
	
	@RequestMapping("/verify/{orderID}")
	public Order verifyOrder(@PathVariable("orderID") Long orderID ) {
		
		Order order = orderService.findyByOrderID(orderID);
		verificationToken token = restTemplate.getForObject("http://inventory-service/inventory/check"+"/"+order.getDrugID()+"/"+order.getDrugQuantity()
		                            ,verificationToken.class);
		int quantity = token.getDrugQuantity();
		if(token.isPresent()==true) {
			int price = token.getDrugAmount();
			order.setDrugPrice(price);
			LocalDate d = LocalDate.now();
			LocalDate p = d.plusDays(5);
			order.setPickUpDate(p);
			order.setVerfied(true);
			order.setDrugQuantity(quantity);
			orderService.saveOrder(order);
			String body = "Your order for "+order.getDrugName()+" for "+order.getDrugQuantity()+" tabs is verified with our inventory and your pickUp date "+ 
			"is set to "+order.getPickUpDate()+"\r\n"+"Order ID : "+order.getOrderID()+"\r\n"+"AMOUNT : "+(float)price;
			String eemail = restTemplate.getForObject("http://user-service/user/email/"+order.getUserID(), String.class);
			String smsBody="\r\nYour order for "+order.getDrugName()+" for "+order.getDrugQuantity()+" tabs is verified with our inventory and your pickUp date "+ 
					"is set for "+order.getPickUpDate()+"\r\n"+"Order ID : "+order.getOrderID()+"\r\n"+"AMOUNT : "+(float)price;
			email email = new email();
			email.setToEmail(eemail);
			email.setBody(body);
			email.setSubject("ORDER IS VERFIED FOR PICKUP");
			template.convertAndSend(mqConfig.EXCHANGE, mqConfig.ROUTING_KEY, email);
			SMS sms = new SMS();
			sms.setMessage(smsBody);
			template.convertAndSend(mqConfig.EXCHANGE, mqConfig.ROUTING_KEY, sms);
			return order;
		}
		else {
			order.setDrugPrice(1000);
			order.setPickUpDate(null);
			order.setVerfied(false);
			orderService.saveOrder(order);
			return order;
		}
	}
	@GetMapping("/unverified")
	public List<Order> unverifiedOrders(){
		
		List<Order> orders = orderService.findAll();
		List<Order> unverified = new ArrayList<Order>();
	
		for(Order e : orders) {
			if( !e.isVerfied()) {
				unverified.add(e);
			}
		}
		return unverified;
	}
	@RabbitListener(queues= mqConfig.QUEUE)
	public void listenToOrders(OrderToken token) {
		Order order = new Order();
		order.setDrugID(token.getDrugID());
		order.setDrugName(token.getDrugName());
		order.setDrugPrice(0);
		order.setDrugQuantity(token.getDrugQuantity());
		order.setOrderDate(LocalDate.now());
		order.setPickUpDate(null);
		order.setUserID(token.getUserID());
		order.setVerfied(false);
		orderService.saveOrder(order);
	}
	@RequestMapping("/check/{orderID}")
	public Order verifiedOrder(@PathVariable("orderID") Long orderID) {
		Order order = orderService.findyByOrderID(orderID);
		return order;
	}
	@GetMapping("/{orderID}")
	public Order getUserOrder(@PathVariable ("orderID") Long orderID) {
		return orderService.findyByOrderID(orderID);
	}
	@GetMapping("/orders")
	public List<Order> getOrders(){
		return orderService.findAll();
	}
	@PutMapping("/update")
	public Order updateOrder(@RequestBody Order order)   
	{  
	orderService.saveOrUpdate(order);  
	return order;  
	}
	@DeleteMapping("/delete/{orderID}")
	public void deleteOrder(@PathVariable("orderID") Long orderID) {
		orderService.deleteOrder(orderID);
	}
}
