package com.example.springlabs.domain.mapper;

import java.util.List;
import java.util.Objects;

import com.example.springlabs.domain.Orders;
import com.example.springlabs.domain.dto.CreateOrderRequest;
import com.example.springlabs.domain.dto.CreateOrderResponse;

public class OrderMapper {
	public static Orders toOrder(CreateOrderRequest createOrderRequest) {
		return new Orders(
				createOrderRequest.companyId(),
				createOrderRequest.memberId()
		);
	}

	public static CreateOrderResponse toCreateOrderResponse(Long orderId) {
		return new CreateOrderResponse(orderId);
	}

	public static List<Integer> toScores(List<Orders> orders) {
		return orders.stream()
				.map(Orders::getScore)
				.filter(Objects::nonNull)  // 쿼리로 Null filter 하는 것과 비교할 것
				.toList();
	}
}
