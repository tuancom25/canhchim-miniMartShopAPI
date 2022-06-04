package com.canhchim.martapi.module.categoryProduct.repository;

import com.canhchim.martapi.entity.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Integer> {
}