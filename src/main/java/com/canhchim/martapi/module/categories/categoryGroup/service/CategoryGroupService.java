// Author : Trung
package com.canhchim.martapi.module.categories.categoryGroup.service;


import com.canhchim.martapi.dto.category.CategoryGroupDto;
import com.canhchim.martapi.entity.CategoryGroup;
import com.canhchim.martapi.module.categories.categoryGroup.repo.CategoryGroupRepository;
import com.canhchim.martapi.module.categories.category.repo.CategoryRepository;
import com.canhchim.martapi.module.categories.convert.Convert;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryGroupService {

    private final CategoryGroupRepository categoryGroupRepository;

    private final MessagesUtils messagesUtils;

    private final ModelMapper modelMapper;
    private final Convert convert;
    // Get All CategoryGroup
    public List<CategoryGroup> findAll() {
        return categoryGroupRepository.findAll();
    }

    // Get CategoryGroup by Id
    public CategoryGroup findById(Integer id) {
        return categoryGroupRepository.findById(id).orElse(null);
    }
    // Get CategoryGroup by ShopId
    public List<CategoryGroup> findByShopId(Integer shopId) {
        return categoryGroupRepository.findByShopId(shopId);
    }

    // Create CategoryGroup
    public CategoryGroup create( CategoryGroupDto categoryGroupDto) {

        return categoryGroupRepository.save(convert.convertCategoryGroupDtoToEntity(categoryGroupDto));
    }


    public CategoryGroup update(CategoryGroupDto categoryGroupDto) {
        CategoryGroup oldCategoryGroup = findById(categoryGroupDto.getId());
        oldCategoryGroup = convert.convertCategoryGroupDtoToEntity(categoryGroupDto);
        return categoryGroupRepository.save(oldCategoryGroup);
    }

    // Delete CategoryGroup
    public void delete(Integer id) {
        categoryGroupRepository.deleteById(id);
    }

}
