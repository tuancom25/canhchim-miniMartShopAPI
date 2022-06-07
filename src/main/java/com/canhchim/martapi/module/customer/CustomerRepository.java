package com.canhchim.martapi.module.customer;

import com.canhchim.martapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}