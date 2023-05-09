package com.example.springlabs.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateOrderRequest(
		@NotNull
		@Positive
		Long orderId,

		@NotNull
		@Positive
		Integer orderScore
) {
}
