package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductInputDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductInputDetailRepository extends JpaRepository<ProductInputDetail, Long> {
    @Query("select p from ProductInputDetail p where p.productInput.shop.id = ?1")
    List<ProductInputDetail> findByProductInput_Shop_Id(Integer id);

    boolean existsByProductInput_Id(Long id);
}