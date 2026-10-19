package io.dev.rfc9457springboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.dev.rfc9457springboot.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
