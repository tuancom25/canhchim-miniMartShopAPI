package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.shop.id = ?1")
    List<Product> findByShop_Id(Integer id);


}