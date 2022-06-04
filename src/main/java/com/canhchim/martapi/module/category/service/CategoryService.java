package com.canhchim.martapi.module.category.service;

import com.canhchim.martapi.entity.Category;
import com.canhchim.martapi.module.category.repo.CategoryRepository;
import com.canhchim.martapi.module.categoryGroup.service.CategoryGroupService;
import com.canhchim.martapi.module.shop.shop.service.ShopService;
import com.canhchim.martapi.util.MessageConstants;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final MessagesUtils messagesUtils;
    private final CategoryGroupService categoryGroupService;
    private final ShopService shopService;

    // Get All Category

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
    // Get Category by Id
    public Category findById(Integer id) {
        log.info("Get Category by Id");
        return categoryRepository.findById(id).orElse(null);
    }
    // Get Category by Name
    public Category findByName(String name) throws Exception {
        log.info("Find Category by Name");
        Optional<Category> optionalCategory = categoryRepository.findByName(name);
        if (!optionalCategory.isPresent()) {
            throw new Exception(messagesUtils.getMessage(MessageConstants.MESSAGE_CATEGORY_NOT_FOUND));
        }
        return optionalCategory.get();
    }
    // Get Category by Code
    public  Category findByCode(Integer code) {
        return categoryRepository.findByCode(code);
    }
    // Get Category by CodeParent
    public List<Category> findByCodeParent(Integer codeParent) {
        return categoryRepository.findByCodeParent(codeParent);
    }
    // Get Category by CategoryGroupId
    public List<Category> findByCategoryGroupId(Integer categoryGroupId) {
        return categoryRepository.findByCategoryGroupId(categoryGroupId);
    }
    // Get Category by CategoryShopId
    public List<Category> findByShopId(Integer categoryShopId) {
        return categoryRepository.findByShopId(categoryShopId);
    }
    // Create Category
    @Transactional(rollbackFor = Exception.class)
    public Category create( CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setCategoryGroup(categoryGroupService.findById(categoryDto.getCategoryGroupId()));
        category.setShop(shopService.getShopById(categoryDto.getShopId()));
        return categoryRepository.save(category);
    }
    // Update Category
    public Category update(CategoryDto categoryDto) {
        Category oldCategory = findById(categoryDto.getId());
        modelMapper.map(categoryDto, oldCategory);
        return categoryRepository.save(oldCategory);
    }
    // Delete Category
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
