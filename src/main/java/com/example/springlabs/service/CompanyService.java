package com.example.springlabs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.springlabs.domain.Company;
import com.example.springlabs.domain.dto.CreateCompanyRequest;
import com.example.springlabs.domain.mapper.CompanyMapper;
import com.example.springlabs.repository.CompanyRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyService {
	private final CompanyRepository companyRepository;

	@Transactional
	public Long createCompany(CreateCompanyRequest createCompanyRequest) {
		return companyRepository.save(CompanyMapper.toCompany(createCompanyRequest))
				.getId();
	}

	@Transactional
	public void calculateGrade(Long companyId, Double grade) {
		log.debug("transaction name : " + TransactionSynchronizationManager.getCurrentTransactionName());

		Company company = companyRepository.findById(companyId)
				.orElseThrow(EntityNotFoundException::new);
		company.updateGrade(grade);

		log.debug("async work is completed");
	}
}
