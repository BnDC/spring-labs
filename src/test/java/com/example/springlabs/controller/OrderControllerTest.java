package com.example.springlabs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springlabs.domain.Company;
import com.example.springlabs.domain.Orders;
import com.example.springlabs.domain.dto.UpdateOrderRequest;
import com.example.springlabs.repository.CompanyRepository;
import com.example.springlabs.repository.OrderRepository;
import com.example.springlabs.utils.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Test
	void updateOrderScore() throws Exception {
		// when
		Company company = companyRepository.save(
				TestUtil.getCompany("name1", "intro1")
		);

		for (int i = 0; i < 5000; i++) {
			orderRepository.save(TestUtil.getOrder(company.getId(), (long)i, i));
		}

		Orders order = orderRepository.save(TestUtil.getOrder(1L, (long)5000));
		Long orderId = order.getId();
		Integer orderScore = 5000;

		// given
		mockMvc.perform(patch("/orders")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new UpdateOrderRequest(orderId, orderScore)))
				)
				.andExpect(status().isOk())
				.andDo(print());

		double expectedGrade = IntStream.rangeClosed(0, 5000)
				.average()
				.getAsDouble();

		Company foundCompany = companyRepository.findById(company.getId()).get();

		// then
		Assertions.assertThat(foundCompany.getGrade())
				.isEqualTo(expectedGrade);
	}
}