package com.darkroom.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darkroom.main.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

}
