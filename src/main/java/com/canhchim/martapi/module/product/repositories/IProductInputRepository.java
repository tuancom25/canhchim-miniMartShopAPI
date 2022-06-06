package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductInput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductInputRepository extends JpaRepository<ProductInput, Integer> {
    List<ProductInput> findByUserInput_Shop_Id(Integer id);


}