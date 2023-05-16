package com.example.springlabs.utils;

import com.example.springlabs.domain.Company;
import com.example.springlabs.domain.Orders;

public class TestUtil {

	public static Orders getOrder(Long companyId, Long memberId) {
		return new Orders(companyId, memberId);
	}

	public static Orders getOrder(Long companyId, Long memberId, Integer orderScore) {
		Orders savedOrder = new Orders(companyId, memberId);
		savedOrder.updateScore(orderScore);
		return savedOrder;
	}

	public static Company getCompany(String name, String introduction) {
		return new Company(name, introduction);
	}

}
