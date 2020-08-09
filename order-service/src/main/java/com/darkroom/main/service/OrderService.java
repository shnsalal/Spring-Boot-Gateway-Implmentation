package com.darkroom.main.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.darkroom.main.common.Payment;
import com.darkroom.main.common.TransactionRequest;
import com.darkroom.main.common.TransactionResponse;
import com.darkroom.main.entity.Order;
import com.darkroom.main.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
//	RestTemplate template = new RestTemplate();
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		order.setOrderId(UUID.randomUUID().toString());
		Payment payment = request.getPayment();
		payment.setOrderId(order.getOrderId());
		payment.setAmount(order.getPrice());
		// rest call
			Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		
		response = paymentResponse.getPaymentStatus().equals("success")?"payment proccessing successful and order placed":"there is a failure in payment api, order added to card";	
		 	
		repository.save(order);
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
	}
}
