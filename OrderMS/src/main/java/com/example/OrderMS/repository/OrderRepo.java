package com.example.OrderMS.repository;

import com.example.OrderMS.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
