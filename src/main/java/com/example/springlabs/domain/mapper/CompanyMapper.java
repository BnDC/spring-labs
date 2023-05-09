package com.example.springlabs.domain.mapper;

import com.example.springlabs.domain.Company;
import com.example.springlabs.domain.dto.CreateCompanyRequest;

public class CompanyMapper {
	public static Company toCompany(CreateCompanyRequest createCompanyRequest) {
		return new Company(
				createCompanyRequest.name(),
				createCompanyRequest.introduction()
		);
	}
}
