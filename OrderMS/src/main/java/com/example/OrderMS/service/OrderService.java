package com.example.OrderMS.service;

import com.example.OrderMS.entity.Order;
import com.example.OrderMS.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
