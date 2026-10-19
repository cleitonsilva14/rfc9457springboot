# rfc9457springboot


```conf
spring.application.name=rfc9457springboot

server.port=9090

# Jpa
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=false
spring.jpa.hibernate.ddl-auto=update

# H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# habilita o suporte nativo
spring.mvc.problemdetails.enabled=true
```


```java
package io.dev.rfc9457springboot.service;

public Order create(Order order) {
		
		if(order.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
			throw new OrderPaymentException("Total de pagamento tem que ser >= 0");
		}
		
		order.setCreatedAt(LocalDateTime.now());
		return orderRepository.save(order);
}
```

```java
package io.dev.rfc9457springboot.exceptions;

public class OrderPaymentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderPaymentException(String message) {
		super(message);
	}

}
```


```java
package io.dev.rfc9457springboot.exceptions;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderPaymentException.class)
	public ProblemDetail handleOrderPaymentException(OrderPaymentException exception, HttpServletRequest request) {
		
		ProblemDetail problem = ProblemDetail
				.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());

    // Inclui propriedades customizadas/adicionais
		problem.setProperty("timestamp", Instant.now());
		
		return problem;
	}
	
}

```
















