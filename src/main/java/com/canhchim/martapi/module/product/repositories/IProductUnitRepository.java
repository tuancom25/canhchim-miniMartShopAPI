package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductUnitRepository extends JpaRepository<ProductUnit, Integer> {
}