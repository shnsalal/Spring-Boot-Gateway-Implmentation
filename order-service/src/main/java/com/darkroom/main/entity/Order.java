package com.darkroom.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_TB")
public class Order {
	
	@Id
	private String orderId;
	private String name;
	private int qty;
	private double price;
	
	public Order() {
		
	}
	
	public Order(String orderId, String name, int qty, double price) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}