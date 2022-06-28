// Author : Trung

package com.canhchim.martapi.module.categories.category.service;

import com.canhchim.martapi.dto.category.CategoryDto;
import com.canhchim.martapi.entity.Category;
import com.canhchim.martapi.module.categories.category.repo.CategoryRepository;
import com.canhchim.martapi.module.categories.categoryGroup.service.CategoryGroupService;
import com.canhchim.martapi.module.categories.convert.Convert;
import com.canhchim.martapi.module.shop.service.ShopService;
import com.canhchim.martapi.util.MessageConstants;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final MessagesUtils messagesUtils;
    private final CategoryGroupService categoryGroupService;
    private final ShopService shopService;
    private final Convert convert;

    // Get All Category

    public Page<CategoryDto> findAll(int page, int size) {
        Page<Category> categoryList = categoryRepository.findAllCategory(PageRequest.of(page,size));
        return categoryList.map(convert::convertCategoryToDto);
    }
    // Get Category by Id
    public CategoryDto findById(Integer id) throws Exception {
        Optional<Category> optionalCategory =categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            throw new Exception(messagesUtils.getMessage(MessageConstants.Category_ERROR_NOT_FOUND));
        }else {
            return convert.convertCategoryToDto(optionalCategory.get());
        }

    }

    public Category findShopById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }


    // Get Category by CodeParent
    public List<CategoryDto> findBycategoryParent(Integer codeParent) {
        List<Category> categoryList = categoryRepository.findBycategoryParent(codeParent);
        return categoryList.stream().map(convert::convertCategoryToDto).collect(Collectors.toList());
    }
    // Get Category by CategoryGroupId
    public List<CategoryDto> findByCategoryGroupId(Integer categoryGroupId) {
        List<Category> categoryList = categoryRepository.findByCategoryGroupId(categoryGroupId);
        return categoryList.stream().map(convert::convertCategoryToDto).collect(Collectors.toList());
    }
    // Get Category by CategoryShopId
    public List<CategoryDto> findByShopId(Integer categoryShopId) {
        List<Category> categoryList = categoryRepository.findByShopId(categoryShopId);
        return categoryList.stream().map(convert::convertCategoryToDto).collect(Collectors.toList());
    }
    // Create Category
    @Transactional(rollbackFor = Exception.class)
    public CategoryDto create( CategoryDto categoryDto) {
        categoryRepository.save(convert.convertCategoryDtoToEntity(categoryDto));
        return categoryDto;
    }
    // Update Category
    public CategoryDto update(CategoryDto categoryDto) {
        Category oldCategory = findShopById(categoryDto.getId());
        oldCategory = categoryRepository.save(convert.convertCategoryDtoToEntity(categoryDto));
        return categoryDto;
    }
    // Delete Category
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
