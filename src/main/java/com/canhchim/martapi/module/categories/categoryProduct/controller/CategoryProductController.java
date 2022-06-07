// Author : Trung
package com.canhchim.martapi.module.categories.categoryProduct.controller;

import com.canhchim.martapi.dto.category.CategoryProductDto;
import com.canhchim.martapi.entity.CategoryProduct;
import com.canhchim.martapi.module.categories.categoryProduct.service.CategoryProductService;
import com.canhchim.martapi.module.categories.convert.Convert;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/categoryProduct")
@RequiredArgsConstructor
public class CategoryProductController {

    private final CategoryProductService categoryProductService;
    // Get All CategoryProduct
    @GetMapping(path = "/findAll")
    public ResponseEntity<List<CategoryProductDto>> getAllCategoryProduct() {
        return ResponseEntity.ok(categoryProductService.findAll());
    }

    // Get CategoryProduct by Id
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<CategoryProductDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoryProductService.findById(id));
    }
    // Get CategoryProduct by ShopId
    @GetMapping(path = "/findByShopId/{shopId}")
    public ResponseEntity<List<CategoryProductDto>> findByShopId(@PathVariable("shopId") Integer shopId) {
        return ResponseEntity.ok(categoryProductService.findByShopId(shopId));
    }
    // Create CategoryProduct
    @PostMapping(path = "/create")
    public ResponseEntity<CategoryProductDto> createCategoryProduct(@Valid @RequestBody CategoryProductDto categoryProductDto) {
        return ResponseEntity.ok(categoryProductService.create(categoryProductDto));
    }
    // Update CategoryProduct
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CategoryProductDto> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoryProductDto categoryProductDto) {
        categoryProductDto.setId(id);
        return ResponseEntity.ok(categoryProductService.update(categoryProductDto));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteCategoryProduct(@PathVariable("id") Integer id) {
        categoryProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
