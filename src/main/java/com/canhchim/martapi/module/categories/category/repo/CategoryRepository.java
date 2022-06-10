package com.canhchim.martapi.module.categories.category.repo;

import com.canhchim.martapi.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c")
    Page<Category> findAllCategory(Pageable pageable);


    List<Category> findBycategoryParent(Integer categoryCodeParent);
    List<Category> findByCategoryGroupId(Integer categoryGroupId);
    List<Category> findByShopId(Integer categoryShop);
}