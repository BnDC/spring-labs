package com.example.springlabs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springlabs.domain.Orders;
import com.example.springlabs.domain.dto.CreateOrderRequest;
import com.example.springlabs.domain.mapper.OrderMapper;
import com.example.springlabs.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;

	@Transactional
	public Long createOrder(CreateOrderRequest createOrderRequest) {
		return orderRepository.save(
				OrderMapper.toOrder(createOrderRequest)
		).getId();
	}

	@Transactional
	public List<Orders> findAllByCompanyId(Long companyId) {
		return orderRepository.findAllByCompanyId(companyId);
	}

	@Transactional
	public Orders updateOrder(Long orderId, Integer orderScore) {
		Orders order = orderRepository.findById(orderId)
				.orElseThrow(EntityNotFoundException::new);
		order.updateScore(orderScore);
		return order;
	}
}
