package io.dev.rfc9457springboot.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderPaymentException.class)
	public ProblemDetail handleOrderPaymentException(OrderPaymentException exception, HttpServletRequest request) {
		
		ProblemDetail problem = ProblemDetail
				.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
		
		problem.setProperty("timestamp", Instant.now());
		
		return problem;
	}
	
}
