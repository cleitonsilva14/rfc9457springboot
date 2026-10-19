package io.dev.rfc9457springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dev.rfc9457springboot.model.Order;
import io.dev.rfc9457springboot.service.OrderService;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

	private final OrderService orderService;
	
	
	@GetMapping
	public ResponseEntity<List<Order>> findOrders() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(orderService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(orderService.create(order));
	}

	
	
}
