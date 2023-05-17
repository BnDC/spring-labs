package com.example.springlabs.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Component
// @WebFilter(urlPatterns = "/api/**")
public class LogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
			IOException,
			ServletException {
		log.info("Hello from: " + request.getLocalAddr());
		chain.doFilter(request, response);
	}
}
