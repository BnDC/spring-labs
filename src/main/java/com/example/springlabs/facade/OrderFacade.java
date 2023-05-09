package com.example.springlabs.facade;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.springlabs.annotation.Facade;
import com.example.springlabs.domain.Orders;
import com.example.springlabs.domain.dto.CreateOrderRequest;
import com.example.springlabs.domain.mapper.OrderMapper;
import com.example.springlabs.event.OrderUpdatedEventPublisher;
import com.example.springlabs.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Facade
@RequiredArgsConstructor
public class OrderFacade {

	private final OrderService orderService;
	private final OrderUpdatedEventPublisher orderUpdatedEventPublisher;

	@Transactional
	public Long createOrder(CreateOrderRequest createOrderRequest) {
		return orderService.createOrder(createOrderRequest);
	}

	@Transactional
	public void updateOrder(Long orderId, Integer orderScore) {
		Orders order = orderService.updateOrder(orderId, orderScore);
		List<Orders> companies = orderService.findAllByCompanyId(order.getCompanyId());

		log.debug(Thread.currentThread().getName());
		log.debug("Transaction Name : " + TransactionSynchronizationManager.getCurrentTransactionName());

		orderUpdatedEventPublisher.publishOrderUpdateEvent(
				order.getCompanyId(), OrderMapper.toScores(companies)
		);
	}
}
