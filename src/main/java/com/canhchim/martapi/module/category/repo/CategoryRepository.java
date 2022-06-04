package com.canhchim.martapi.module.category.repo;

import com.canhchim.martapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCode(Integer categoryCode);
    Optional<Category> findByName(String categoryName);
    List<Category> findByCodeParent(Integer categoryCodeParent);
    List<Category> findByCategoryGroupId(Integer categoryGroupId);
    List<Category> findByShopId(Integer categoryShop);
}