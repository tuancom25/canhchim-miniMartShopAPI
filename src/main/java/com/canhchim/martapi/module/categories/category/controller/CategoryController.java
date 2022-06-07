//Author :Trung

package com.canhchim.martapi.module.categories.category.controller;

import com.canhchim.martapi.dto.category.CategoryDto;
import com.canhchim.martapi.module.categories.category.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;


    // Get All Category
    @GetMapping("/findAll")
    public ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }
    // Get Category by Id
    @GetMapping("/findById/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
    // Get Category by CodeParent
    @GetMapping("/findByCategoryParent/{codeParent}")
    public ResponseEntity<List<CategoryDto>> findByCategoryParent(@PathVariable("codeParent") Integer codeParent) {
        return ResponseEntity.ok(categoryService.findBycategoryParent(codeParent));
    }

    // Get Category by CategoryGroup
    @GetMapping("/findByCategoryGroupId/{categoryGroupId}")
    public ResponseEntity<List<CategoryDto>> findByCategoryGroup(@PathVariable("categoryGroupId") Integer categoryGroupId) {
        return ResponseEntity.ok(categoryService.findByCategoryGroupId(categoryGroupId));
    }
    // Get Category by ShopId
    @GetMapping("/findByShopId/{categoryShopId}")
    public ResponseEntity<List<CategoryDto>> getCategoryByCategoryShopId(@PathVariable("categoryShopId") Integer categoryShopId) {
        return ResponseEntity.ok(categoryService.findByShopId(categoryShopId));
    }
    // Create Category
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(categoryDto));
    }
    // Update Category
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable("id") Integer id ,@Valid @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        return ResponseEntity.ok(categoryService.update(categoryDto));
    }
    // Delete Category
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
