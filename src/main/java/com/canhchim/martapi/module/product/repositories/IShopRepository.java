package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShopRepository extends JpaRepository<Shop, Integer> {
}