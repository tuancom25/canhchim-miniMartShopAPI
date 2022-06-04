package com.canhchim.martapi.module.categoryProduct.controller;

import com.canhchim.martapi.entity.CategoryProduct;
import com.canhchim.martapi.module.categoryProduct.service.CategoryProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/categoryProduct")
@RequiredArgsConstructor
public class CategoryProductController {

    private final CategoryProductService categoryProductService;
    private final ModelMapper modelMapper;

    // Get All CategoryProduct
//    @GetMapping(path = "/findAll")
//    public ResponseEntity<List<CategoryProduct>> getAllCategoryProduct() {
//        return ResponseEntity.ok(categoryProductService.findAll());
//    }

    // Get CategoryProduct by Id
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<CategoryProductDto> findById(@PathVariable("id") Integer id) {
        CategoryProduct categoryProduct = categoryProductService.findById(id);
        CategoryProductDto categoryProductDto = modelMapper.map(categoryProduct,CategoryProductDto.class);
        categoryProductDto.setShopId(categoryProduct.getShop().getId());
        return ResponseEntity.ok(categoryProductDto);
    }


    // Create CategoryProduct
    @PostMapping(path = "/create")
    public ResponseEntity<CategoryProductDto> createCategoryProduct(@Valid @RequestBody CategoryProductDto categoryProductDto) {
        CategoryProduct categoryProduct = categoryProductService.create(categoryProductDto);
        return ResponseEntity.ok(categoryProductDto);
    }
    // Update CategoryProduct
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CategoryProductDto> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoryProductDto categoryProductDto) {
        categoryProductDto.setId(id);
        CategoryProduct categoryProduct = categoryProductService.update(categoryProductDto);
        return ResponseEntity.ok(categoryProductDto);
    }
    // Delete CategoryProduct
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteCategoryProduct(@PathVariable("id") Integer id) {
        categoryProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
