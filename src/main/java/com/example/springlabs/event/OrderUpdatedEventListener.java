package com.example.springlabs.event;

import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.springlabs.service.CompanyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderUpdatedEventListener {

	private final CompanyService companyService;

	@EventListener
	public void calculateUpdatedGrade(OrderUpdatedEvent orderUpdateEvent) {
		log.info("orderUpdateEvent published");

		List<Integer> scores = orderUpdateEvent.getScores();
		int size = scores.size();
		Double grade = 0.0;
		for (Integer score : scores) {
			grade += score;
		}
		grade /= size;

		log.debug(Thread.currentThread().getName());
		log.debug("isActivated: " + TransactionSynchronizationManager.isActualTransactionActive());
		log.debug("Transaction name" + TransactionSynchronizationManager.getCurrentTransactionName());

		companyService.calculateGrade(orderUpdateEvent.getCompanyId(), grade);
	}
}
