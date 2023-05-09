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
public class Company {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "introduction", unique = true, nullable = false)
	private String introduction;

	@Column(name = "grade", unique = true, nullable = true)
	private Double grade;

	public Company(String name, String introduction) {
		this.name = name;
		this.introduction = introduction;
	}

	public void updateGrade(Double grade) {
		this.grade = grade;
	}
}