package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query("select p from ProductType p where p.shop.id = ?1")
    List<ProductType> findByShop_Id(Integer id);
    @Query("select p from ProductType p where p.name = ?1 and p.code = ?2")
    ProductType findByProductTypeCodeAndProductTypeName(String name, Integer code);
    @Query("select p from ProductType p where p.shop.id = ?1")
    Page<ProductType> getPage(Integer id, Pageable pageable);

}