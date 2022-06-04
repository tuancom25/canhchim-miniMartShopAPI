package com.canhchim.martapi.module.category.controller;

import com.canhchim.martapi.entity.Category;
import com.canhchim.martapi.module.category.repo.CategoryRepository;
import com.canhchim.martapi.module.category.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    // Get All Category
    @GetMapping("/findAll")
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> categoryList = categoryService.findAll();

        return ResponseEntity.ok(categoryList.stream().map(category -> modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList()));
    }
    // Get Category by Id
    @GetMapping("/findById/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") Integer id) {
        Category category = categoryService.findById(id);
        CategoryDto categoryDto = modelMapper.map(category,CategoryDto.class);
        categoryDto.setCategoryGroupId(category.getCategoryGroup().getId());
        categoryDto.setShopId(category.getShop().getId());
        return ResponseEntity.ok(categoryDto);
    }
    // Get Category by Name
    @GetMapping("/findByName/{name}")
    public ResponseEntity<CategoryDto> findByName(@PathVariable("name") String name) throws Exception {
        Category category = categoryService.findByName(name);
        CategoryDto categoryDto = modelMapper.map(category,CategoryDto.class);
        categoryDto.setCategoryGroupId(category.getCategoryGroup().getId());
        categoryDto.setShopId(category.getShop().getId());
        return ResponseEntity.ok(categoryDto);
    }
    // Get Category by Code
    @GetMapping("/findByCode/{code}")
    public ResponseEntity<CategoryDto> findByCode(@PathVariable("code") Integer code) {
        Category category = categoryService.findByCode(code);
        CategoryDto categoryDto = modelMapper.map(category,CategoryDto.class);
        categoryDto.setCategoryGroupId(category.getCategoryGroup().getId());
        categoryDto.setShopId(category.getShop().getId());
        return ResponseEntity.ok(categoryDto);
    }

    // Get Category by CodeParent
    @GetMapping("/findByCodeParent/{codeParent}")
    public ResponseEntity<List<CategoryDto>> findByCodeParent(@PathVariable("codeParent") Integer codeParent) {
        List<Category> categoryList = categoryService.findByCodeParent(codeParent);
        return ResponseEntity.ok(categoryList.stream().map(category -> modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList()));
    }
    // Get Category by CategoryGroup
    @GetMapping("/findByCategoryGroupId/{categoryGroupId}")
    public ResponseEntity<List<Category>> findByCategoryGroup(@PathVariable("categoryGroupId") Integer categoryGroupId) {
        return ResponseEntity.ok(categoryService.findByCategoryGroupId(categoryGroupId));
    }
    // Get Category by ShopId
    @GetMapping("/findByShopId/{categoryShopId}")
    public ResponseEntity<List<Category>> getCategoryByCategoryShopId(@PathVariable("categoryShopId") Integer categoryShopId) {
        return ResponseEntity.ok(categoryService.findByShopId(categoryShopId));
    }
    // Create Category
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(null);
        Category category = categoryService.create(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(category, CategoryDto.class));
    }
    // Update Category
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Integer id ,@Valid @RequestBody CategoryDto categoryDto) {
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
