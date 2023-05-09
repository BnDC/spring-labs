package com.example.springlabs.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlabs.domain.dto.CreateOrderRequest;
import com.example.springlabs.domain.dto.UpdateOrderRequest;
import com.example.springlabs.facade.OrderFacade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderFacade orderFacade;

	@PostMapping("/new")
	public void createOrder(@Validated @RequestBody CreateOrderRequest createOrderRequest) {
		orderFacade.createOrder(createOrderRequest);
	}

	@PatchMapping
	public void updateOrderScore(@Validated @RequestBody UpdateOrderRequest updateOrderRequest) {
		orderFacade.updateOrder(updateOrderRequest.orderId(), updateOrderRequest.orderScore());

		log.info("response is sent");
	}
}
