package io.dev.rfc9457springboot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import io.dev.rfc9457springboot.enums.DocumentType;
import io.dev.rfc9457springboot.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID orderUUID;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", nullable = false)
	private OrderStatus orderStatus;

	@Column(name = "total", precision = 10, scale = 2, nullable = false)
	private BigDecimal total = BigDecimal.ZERO;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "buyer_name", nullable = false, length = 255)
	private String buyerName;
	
	@Column(name = "document", nullable = false, length = 20)
	private String document;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", nullable = false)
	private DocumentType documentType;
	
	
}
