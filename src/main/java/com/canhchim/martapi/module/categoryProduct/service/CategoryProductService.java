package com.canhchim.martapi.module.categoryProduct.service;

import com.canhchim.martapi.entity.CategoryProduct;
import com.canhchim.martapi.module.categoryProduct.repository.CategoryProductRepository;
import com.canhchim.martapi.module.shop.shop.service.ShopService;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;
    private final ShopService shopService;
    private final ModelMapper modelMapper;
    private final MessagesUtils messagesUtils;
    // Get All CategoryProduct
//    public List<CategoryProduct> findAll() {
//        log.info("Get All CategoryProduct");
//        List<CategoryProduct> categoryProduct = categoryProductRepository.findAll();
//        return cate;
//    }
    // Get CategoryProduct by Id
    public CategoryProduct findById(Integer id) {
        log.info("Get CategoryProduct by Id");
        return categoryProductRepository.findById(id).orElse(null);
    }


    // Create CategoryProduct
    public CategoryProduct create(CategoryProductDto categoryProductDto) {
        log.info("Add CategoryProduct to database");
        CategoryProduct categoryProduct = modelMapper.map(categoryProductDto, CategoryProduct.class);
        categoryProduct.setShop(shopService.getShopById(categoryProductDto.getShopId()));
        return categoryProductRepository.save(categoryProduct);
    }
    // Update CategoryProduct
    public CategoryProduct update(CategoryProductDto categoryProductDto) {
        CategoryProduct oldCategoryProduct = findById(categoryProductDto.getId());
        log.info("Update CategoryProduct");
        modelMapper.map(categoryProductDto, oldCategoryProduct);
        oldCategoryProduct.setShop(shopService.getShopById(categoryProductDto.getShopId()));
        return categoryProductRepository.save(oldCategoryProduct);
    }
    // Delete CategoryProduct
    public void delete(Integer id) {
        log.info("Delete CategoryProduct");
        categoryProductRepository.deleteById(id);
    }
}
