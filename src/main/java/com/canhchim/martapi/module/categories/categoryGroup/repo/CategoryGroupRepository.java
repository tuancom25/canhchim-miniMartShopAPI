package com.canhchim.martapi.module.categories.categoryGroup.repo;

import com.canhchim.martapi.entity.CategoryGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryGroupRepository extends JpaRepository<CategoryGroup, Integer> {


    List<CategoryGroup> findByShopId(Integer shopId);
    boolean existsByName(String name);


}