package com.darkroom.main.common;

public class Payment {
	
	private String paymentStatus;
	private String transactionId;
	private String orderId;
	private double amount;
	
	public Payment() {
		
	}
	
	public Payment(int paymentId, String paymentStatus, String transactionId, String orderId, double amount) {
		super();
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.amount = amount;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
