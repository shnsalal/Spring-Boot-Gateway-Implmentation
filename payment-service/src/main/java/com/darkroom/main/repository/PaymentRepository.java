package com.darkroom.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darkroom.main.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Payment findByOrderId(String orderId);

}
