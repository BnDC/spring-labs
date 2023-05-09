package com.example.springlabs.domain.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderRequest(
		@NotNull
		@Positive
		Long companyId,

		@NotNull
		@Positive
		Long memberId
) {
}
