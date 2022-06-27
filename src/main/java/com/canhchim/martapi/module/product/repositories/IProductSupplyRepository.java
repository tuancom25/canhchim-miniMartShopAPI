package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductSupply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductSupplyRepository extends JpaRepository<ProductSupply, Long> {
    @Query("select p from ProductSupply p where p.shop.id = ?1")
    List<ProductSupply> findByShop_Id(Integer id);

    @Query("select p from ProductSupply p where p.shop.id = ?1")
    Page<ProductSupply> findByShop_Id(Pageable pageable, Integer id);
    
    @Query("select p from ProductSupply p where p.name = ?1 and p.address = ?2")
    Optional<ProductSupply> findByNameAndAddress(String name, String address);

    Optional<ProductSupply> findById(int aLong);


}