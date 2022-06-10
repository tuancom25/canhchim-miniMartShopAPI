// Author : Trung
package com.canhchim.martapi.module.categories.categoryProduct.controller;

import com.canhchim.martapi.dto.ResponseDto;
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
    public ResponseEntity<?> getAllCategoryProduct(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                          @RequestParam(name = "size", defaultValue = "30") int size) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryProductService.findAll(page, size));
        return ResponseEntity.ok(responseDto);
    }

    // Get CategoryProduct by Id
    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryProductService.findById(id));
        return ResponseEntity.ok(responseDto);
    }
    // Get CategoryProduct by ShopId
    @GetMapping(path = "/findByShopId/{shopId}")
    public ResponseEntity<?> findByShopId(@PathVariable("shopId") Integer shopId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryProductService.findByShopId(shopId));
        return ResponseEntity.ok().body(responseDto);
    }
    // Create CategoryProduct
    @PostMapping(path = "/create")
    public ResponseEntity<?> createCategoryProduct(@Valid @RequestBody CategoryProductDto categoryProductDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoryProductService.create(categoryProductDto));
        return ResponseEntity.ok().body(responseDto);
    }
    // Update CategoryProduct
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoryProductDto categoryProductDto) {
        ResponseDto responseDto = new ResponseDto();
        categoryProductDto.setId(id);
        responseDto.setData(categoryProductService.update(categoryProductDto));
        return ResponseEntity.ok(responseDto);
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteCategoryProduct(@PathVariable("id") Integer id) {
        categoryProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
