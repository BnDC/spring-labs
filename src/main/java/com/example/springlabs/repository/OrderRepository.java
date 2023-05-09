package com.example.springlabs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springlabs.domain.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
	List<Orders> findAllByCompanyId(Long companyId);
}
