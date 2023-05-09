package com.example.springlabs.event;

import java.util.List;

import lombok.Getter;

@Getter
public class OrderUpdatedEvent {

	private final Long companyId;
	private final List<Integer> scores;

	public OrderUpdatedEvent(Long companyId, List<Integer> scores) {
		this.companyId = companyId;
		this.scores = scores;
	}
}
