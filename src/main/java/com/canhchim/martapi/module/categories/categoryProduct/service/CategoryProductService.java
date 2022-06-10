//Author : Trung
package com.canhchim.martapi.module.categories.categoryProduct.service;

import com.canhchim.martapi.dto.category.CategoryProductDto;
import com.canhchim.martapi.entity.CategoryProduct;
import com.canhchim.martapi.module.categories.categoryProduct.repository.CategoryProductRepository;
import com.canhchim.martapi.module.categories.convert.Convert;
import com.canhchim.martapi.module.shop.service.ShopService;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;
    private final ShopService shopService;
    private final MessagesUtils messagesUtils;
    private final Convert convert;

     //Get All CategoryProduct
    public List<CategoryProductDto> findAll(int page,int size) {
        List<CategoryProduct> categoryProductList = categoryProductRepository.findAllCategoryProduct(PageRequest.of(page,size)).toList();
        return categoryProductList.stream().map(convert::convertCategoryProductToDto).collect(Collectors.toList());
    }
    // Get CategoryProduct by Id
    public CategoryProductDto findById(Integer id) {
        CategoryProduct categoryProduct =categoryProductRepository.findById(id).orElse(null);
        assert categoryProduct != null;
        return convert.convertCategoryProductToDto(categoryProduct);
    }
    public CategoryProduct findCategoryProductById(Integer id) {
        return categoryProductRepository.findById(id).orElse(null);
    }
    // Get CategoryProduct by ShopId
    public List<CategoryProductDto> findByShopId(Integer shopId) {
        List<CategoryProduct> categoryProductList = categoryProductRepository.findByShopId(shopId);
        return categoryProductList.stream().map(convert::convertCategoryProductToDto).collect(Collectors.toList());
    }

    // Create CategoryProduct
    public CategoryProductDto create(CategoryProductDto categoryProductDto) {
        log.info("Add CategoryProduct to database");
        categoryProductRepository.save(convert.convertCategoryProductDtoToEntity(categoryProductDto));
        return categoryProductDto;
    }
    // Update CategoryProduct
    public CategoryProductDto update(CategoryProductDto categoryProductDto) {
        CategoryProduct oldCategoryProduct = findCategoryProductById(categoryProductDto.getId());
        oldCategoryProduct = convert.convertCategoryProductDtoToEntity(categoryProductDto);
        categoryProductRepository.save(oldCategoryProduct);
        return categoryProductDto;
    }
    // Delete CategoryProduct
    public void delete(Integer id) {
        log.info("Delete CategoryProduct");
        categoryProductRepository.deleteById(id);
    }
}
