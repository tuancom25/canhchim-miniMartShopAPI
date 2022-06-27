package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductUnitRepository extends JpaRepository<ProductUnit, Integer> {

    @Override
    Page<ProductUnit> findAll(Pageable pageable);
}