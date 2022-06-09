package com.canhchim.martapi.module.company.repository;

import com.canhchim.martapi.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c")
    Page<Company> findAllCompany(Pageable pageable);

    @Query("select c from Company c where c.shop.id = ?1")
    List<Company> findByShopId(Integer id);



}