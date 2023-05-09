package com.example.springlabs.domain;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Orders {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@Column(name = "company_id", nullable = false)
	private Long companyId;

	@Column(name = "member_id", nullable = false)
	private Long memberId;

	@Column(name = "score", nullable = true)
	private Integer score;

	public Orders(Long companyId, Long memberId) {
		this.companyId = companyId;
		this.memberId = memberId;
	}

	public void updateScore(Integer score) {
		this.score = score;
	}
}
