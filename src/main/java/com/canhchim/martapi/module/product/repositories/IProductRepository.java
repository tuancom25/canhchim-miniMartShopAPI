package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.shop.id = ?1 and p.isDeleted = ?2")
    Page<Product> findByShop_IdAndIsDeleted(Integer id, Boolean isDeleted, Pageable pageable);

    @Query("select (count(p) > 0) from Product p where p.code = ?1 and p.shop.id = ?2")
    boolean existsByCodeAndShop_Id(String code, Integer id);

    @Query("select p from Product p where p.code = ?1 and p.shop.id = ?2")
    Optional<Product> findByCodeAndShop_Id(String code, Integer id);

    @Query("select p from Product p where p.code = ?1 and p.shop.id = ?2")
    Page<Product> findByCodeAndShop_Id(Pageable pageable,String code, Integer id);

    @Query("select p from Product p where p.id = ?1 and p.shop.id = ?2 and p.isDeleted = ?3")
    Optional<Product> findByIdAndShop_IdAndIsDeleted(Long id, Integer id1, Boolean isDeleted);

    @Query("delete from Product p where p.id = ?1")
    @Transactional
    @Modifying
    void deleteById(Long id);

    @Query("delete from Product p where p.id = ?1")
    @Transactional
    @Modifying
    Optional<Product> findById(Long id);


}