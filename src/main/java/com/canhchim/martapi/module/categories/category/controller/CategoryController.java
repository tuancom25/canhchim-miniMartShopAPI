//Author :Trung

package com.canhchim.martapi.module.categories.category.controller;

import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.dto.category.CategoryDto;
import com.canhchim.martapi.module.categories.category.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;


    // Get All Category
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                      @RequestParam(value = "size", defaultValue = "50") int size) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryService.findAll(page, size));
        return ResponseEntity.ok(responseDto);
    }
    // Get Category by Id
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryService.findById(id));
        return ResponseEntity.ok(responseDto);
    }
    // Get Category by CodeParent
    @GetMapping("/findByCategoryParent/{codeParent}")
    public ResponseEntity<?> findByCategoryParent(@PathVariable("codeParent") Integer codeParent) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryService.findBycategoryParent(codeParent));
        return ResponseEntity.ok(responseDto);
    }

    // Get Category by CategoryGroup
    @GetMapping("/findByCategoryGroupId/{categoryGroupId}")
    public ResponseEntity<?> findByCategoryGroup(@PathVariable("categoryGroupId") Integer categoryGroupId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryService.findByCategoryGroupId(categoryGroupId));
        return ResponseEntity.ok(responseDto);
    }
    // Get Category by ShopId
    @GetMapping("/findByShopId/{categoryShopId}")
    public ResponseEntity<?> getCategoryByCategoryShopId(@PathVariable("categoryShopId") Integer categoryShopId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryService.findByShopId(categoryShopId));
        return ResponseEntity.ok(responseDto);
    }
    // Create Category
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(null);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryService.create(categoryDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
    // Update Category
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id ,@Valid @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryService.update(categoryDto));
        return ResponseEntity.ok(responseDto);
    }
    // Delete Category
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
