package com.example.OrderMS.controller;


import com.example.OrderMS.entity.Order;
import com.example.OrderMS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.findAll();
    }

}
