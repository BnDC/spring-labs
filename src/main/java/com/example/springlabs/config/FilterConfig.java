package com.example.springlabs.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springlabs.filter.Log2Filter;
import com.example.springlabs.filter.LogFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<LogFilter> filterRegistrationBean() {
		FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new LogFilter());
		registrationBean.addUrlPatterns("/api");
		return registrationBean;
	}

	/*
	@Bean
	public FilterRegistrationBean<Log2Filter> filter2RegistrationBean() {
		FilterRegistrationBean<Log2Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new Log2Filter());
		registrationBean.addUrlPatterns("/not-matched");
		return registrationBean;
	}
	*/

}
