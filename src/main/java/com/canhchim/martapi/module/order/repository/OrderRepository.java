package com.canhchim.martapi.module.order.repository;

import com.canhchim.martapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}