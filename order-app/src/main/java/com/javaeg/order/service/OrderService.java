package com.javaeg.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaeg.order.model.Order;
import com.javaeg.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void processOrder(String orderItem, Float amount, String customerId) {
		if (orderRepository.countByOrderItemAndCustomerId(orderItem, customerId) > 0) {
			log.info("Order already exists !!");
		} else {
			Order order = new Order(orderItem, amount, customerId);
			orderRepository.save(order);
			log.info("Order has been processed!!");
		}
	}
}
