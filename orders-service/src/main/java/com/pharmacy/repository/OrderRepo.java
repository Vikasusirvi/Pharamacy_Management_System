package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entity.Order;

public interface OrderRepo extends JpaRepository<Order,Long> {

}
