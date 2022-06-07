package com.canhchim.martapi.module.categories.categoryGroup.repo;

import com.canhchim.martapi.entity.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryGroupRepository extends JpaRepository<CategoryGroup, Integer> {


}