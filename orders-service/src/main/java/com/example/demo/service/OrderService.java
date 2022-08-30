package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
	public List<Order> findAll(){
		return orderRepo.findAll();
	}
	public Order saveOrUpdate(Order order)   
	{   
	return orderRepo.save(order);  
	}  
	public void deleteOrder(Long orderID) {
		orderRepo.deleteById(orderID);
	}
	public Order  findyByOrderID(Long orderID) {
		 Optional<Order> order =  orderRepo.findById(orderID);
		 if (order.isPresent() == true){
			 return order.get();
		 }
		 else return null;
	}
}
