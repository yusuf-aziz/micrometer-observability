package com.javaeg.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true, length = 30)
	private String orderItem;

	@Column(nullable = true)
	private Float amount;

	@Column(nullable = true, length = 30)
	private String customerId;

	public Order(String orderItem, Float amount, String customerId) {
		this.orderItem = orderItem;
		this.amount = amount;
		this.customerId = customerId;
	}

	public Order() {

	}

}
