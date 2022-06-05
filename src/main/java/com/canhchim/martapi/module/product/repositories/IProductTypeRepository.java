package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query("select p from ProductType p where p.shop.id = ?1")
    List<ProductType> findByShop_Id(Integer id);

    @Query("select p from ProductType p where p.name = ?1 and p.code = ?2")
    ProductType findByProductTypeCodeAndProductTypeName(String name, Integer code);



//    @Query("select p from ProductType p where p.shopId.id = ?1")
//    List<ProductType> findByShop_Id(Integer id);
//
//    @Query("select p from ProductType p where p.productTypeCode = ?1 and p.productTypeName = ?2")
//    Optional<ProductType> findByProductTypeCodeAndProductTypeName(Integer productTypeCode, String productTypeName);


}