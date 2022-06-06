// Author : Trung
package com.canhchim.martapi.module.categories.categoryGroup.service;


import com.canhchim.martapi.dto.category.CategoryGroupDto;
import com.canhchim.martapi.entity.CategoryGroup;
import com.canhchim.martapi.module.categories.categoryGroup.repo.CategoryGroupRepository;
import com.canhchim.martapi.module.categories.category.repo.CategoryRepository;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryGroupService {

    private final CategoryGroupRepository categoryGroupRepository;

    private final MessagesUtils messagesUtils;

    private final ModelMapper modelMapper;

    // Get All CategoryGroup
    public List<CategoryGroup> findAll() {
        log.info("Get All CategoryGroup");
        return categoryGroupRepository.findAll();
    }

    // Get CategoryGroup by Id
    public CategoryGroup findById(Integer id) {
        log.info("Get CategoryGroup by Id");
        return categoryGroupRepository.findById(id).orElse(null);
    }

    // Create CategoryGroup
    public CategoryGroup create(CategoryGroupDto categoryGroupDto) {
        CategoryGroup categoryGroup = modelMapper.map(categoryGroupDto, CategoryGroup.class);
        log.info("Add CategoryGroup to database");
        return categoryGroupRepository.save(categoryGroup);
    }


    public CategoryGroup update(CategoryGroupDto categoryGroupDto) {
        CategoryGroup oldCategoryGroup = findById(categoryGroupDto.getId());
        oldCategoryGroup.setName(categoryGroupDto.getName());
        log.info("Update CategoryGroup to database");
        return categoryGroupRepository.save(oldCategoryGroup);
    }

    // Delete CategoryGroup
    public void delete(Integer id) {
        log.info("Delete CategoryGroup");
        categoryGroupRepository.deleteById(id);
    }

}
