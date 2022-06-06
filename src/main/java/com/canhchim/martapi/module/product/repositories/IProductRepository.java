package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}