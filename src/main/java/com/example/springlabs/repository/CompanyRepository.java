package com.example.springlabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springlabs.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
