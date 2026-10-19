package io.dev.rfc9457springboot.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.dev.rfc9457springboot.exceptions.OrderPaymentException;
import io.dev.rfc9457springboot.model.Order;
import io.dev.rfc9457springboot.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order create(Order order) {
		
		if(order.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
			throw new OrderPaymentException("Total de pagamento tem que ser >= 0");
		}
		
		order.setCreatedAt(LocalDateTime.now());
		return orderRepository.save(order);
	}
	
	
}
