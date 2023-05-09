package com.example.springlabs.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlabs.domain.dto.CreateCompanyRequest;
import com.example.springlabs.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
	private final CompanyService companyService;

	@PostMapping("/new")
	public Long createCompany(@Validated @RequestBody CreateCompanyRequest createCompanyRequest) {
		return companyService.createCompany(createCompanyRequest);
	}
}
