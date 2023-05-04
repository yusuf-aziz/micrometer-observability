package com.javaeg.order.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javaeg.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrderService orderService;

	@GetMapping("/order")
	public Order getOrder(@RequestParam String orderItem, @RequestParam Float amount, String customerId) {
		log.info("Order received.");
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8092/payment?amount=" + amount.floatValue(), String.class);
		log.info(response.getBody());
		orderService.processOrder(orderItem, amount, customerId);
		return new Order(String.format("Order for the item %s has been processed with order-id %s", orderItem,
				UUID.randomUUID()));
	}

	record Order(String orderDesc) {
	}
}
