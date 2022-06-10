// Author : Trung

package com.canhchim.martapi.module.categories.categoryGroup.controller;

import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.dto.category.CategoryGroupDto;
import com.canhchim.martapi.entity.CategoryGroup;
import com.canhchim.martapi.module.categories.categoryGroup.service.CategoryGroupService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoryGroup")
@RequiredArgsConstructor
public class CategoryGroupController {
    private final CategoryGroupService categoryGroupService;
    private final ModelMapper modelMapper;

    // Get All CategoryGroup
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        ResponseDto responseDto = new ResponseDto();
        List<CategoryGroup> categoryGroupList = categoryGroupService.findAll();
        responseDto.setData(categoryGroupList.stream().map(categoryGroup -> modelMapper.map(categoryGroup,CategoryGroupDto.class)).collect(Collectors.toList()));
        return ResponseEntity.ok(responseDto);
    }

    // Get CategoryGroup by Id
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        ResponseDto responseDto = new ResponseDto();
        CategoryGroup categoryGroup = categoryGroupService.findById(id);
        responseDto.setData(modelMapper.map(categoryGroup,CategoryGroupDto.class));
        return ResponseEntity.ok(responseDto);
    }
    // Get CategoryGroup by ShopId
    @GetMapping("/findByShopId/{shopId}")
    public ResponseEntity<?> findByShopId(@PathVariable Integer shopId) {
        ResponseDto responseDto = new ResponseDto();
        List<CategoryGroup> categoryGroupList = categoryGroupService.findByShopId(shopId);
        responseDto.setData(categoryGroupList.stream().map(categoryGroup -> modelMapper.map(categoryGroup,CategoryGroupDto.class)).collect(Collectors.toList()));
        return ResponseEntity.ok(responseDto);
    }

    // Create CategoryGroup
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CategoryGroupDto categoryGroupDto) {
        ResponseDto responseDto = new ResponseDto();
        categoryGroupDto.setId(null);
        CategoryGroup categoryGroup = categoryGroupService.create(categoryGroupDto);
        responseDto.setData(categoryGroupDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
    // Update CategoryGroup
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id ,@Valid @RequestBody CategoryGroupDto categoryGroupDto) {
        ResponseDto responseDto = new ResponseDto();
        categoryGroupDto.setId(id);
        CategoryGroup categoryGroup = categoryGroupService.update(categoryGroupDto);
        responseDto.setData(modelMapper.map(categoryGroup,CategoryGroupDto.class));
        return ResponseEntity.ok(responseDto);
    }
    // Delete CategoryGroup
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        categoryGroupService.delete(id);
    }

}
