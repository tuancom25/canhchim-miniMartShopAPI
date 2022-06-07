package com.canhchim.martapi.module.product.repositories;

import com.canhchim.martapi.entity.ProductInput;
import com.canhchim.martapi.entity.ProductSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface IProductInputRepository extends JpaRepository<ProductInput, Integer> {
    @Transactional
    @Modifying
    @Query("update ProductInput p set p.totalMoney = ?1, p.inputDate2 = ?2, p.supply = ?3 " +
            "where p.totalMoney = ?4 and p.inputDate2 = ?5 and p.supply = ?6")
    void updateTotalMoneyAndInputDate2AndSupplyByTotalMoneyAndInputDate2AndSupply(Long totalMoney, Instant inputDate2, ProductSupply supply, Long totalMoney1, Instant inputDate21, ProductSupply supply1);
    List<ProductInput> findByUserInput_Shop_Id(Integer id);

    @Query("select (count(p) > 0) from ProductInput p where p.id = ?1 and p.userInput.shop.id = ?2")
    boolean existsByIdAndUserInput_Shop_Id(Long id, Integer id1);

    @Override
    @Query("select p from ProductInput p where p.id = ?1")
    Optional<ProductInput> findById(Integer integer);


}