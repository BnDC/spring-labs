package com.example.springlabs.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderUpdatedEventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void publishOrderUpdateEvent(Long companyId, List<Integer> scores) {
		log.info("orderUpdatedEvent published");
		applicationEventPublisher.publishEvent(new OrderUpdatedEvent(companyId, scores));
	}
}
