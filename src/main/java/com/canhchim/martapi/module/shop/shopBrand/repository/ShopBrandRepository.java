package com.canhchim.martapi.module.shop.shopBrand.repository;

import com.canhchim.martapi.entity.ShopBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ShopBrandRepository extends JpaRepository<ShopBrand, Integer> {
    @Query("select s from ShopBrand s where s.id = ?1")
    Optional<ShopBrand> findById(Integer id);
}