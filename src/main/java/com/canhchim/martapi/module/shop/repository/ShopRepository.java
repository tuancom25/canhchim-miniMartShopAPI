package com.canhchim.martapi.module.shop.repository;

import com.canhchim.martapi.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query("select s from Shop s")
    Page<Shop> getPage(Pageable pageable);


}