package com.example.springlabs.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> handleException(Exception e) {
		log.warn("{}", e.getMessage());
		return new ResponseEntity<>(e, HttpStatusCode.valueOf(500));
	}
}
