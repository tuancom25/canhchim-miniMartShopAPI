package com.canhchim.martapi.module.categories.categoryProduct.repository;

import com.canhchim.martapi.entity.CategoryProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Integer> {
    @Query("select c from CategoryProduct c")
    Page<CategoryProduct> findAllCategoryProduct(Pageable pageable);

    List<CategoryProduct> findByShopId(Integer shopId);
}