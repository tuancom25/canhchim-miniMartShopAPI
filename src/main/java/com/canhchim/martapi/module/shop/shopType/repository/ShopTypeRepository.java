package com.canhchim.martapi.module.shop.shopType.repository;

import com.canhchim.martapi.entity.ShopType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopTypeRepository extends JpaRepository<ShopType, Integer> {
    Optional<ShopType> findByName(String shopTypeName);
}