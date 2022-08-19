package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	public void saveOrder(Order order) {
		orderRepo.save(order);
	}
	public List<Order> findAll(){
		return orderRepo.findAll();
	}
	
}
