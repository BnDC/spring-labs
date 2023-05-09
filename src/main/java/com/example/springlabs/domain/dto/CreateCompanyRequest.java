package com.example.springlabs.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCompanyRequest(
		@NotBlank
		String name,
		String introduction
		) {
}
