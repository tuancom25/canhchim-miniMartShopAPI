// Author : Trung

package com.canhchim.martapi.module.categories.categoryGroup.controller;

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
    public ResponseEntity<List<CategoryGroupDto>> findAll() {
        List<CategoryGroup> categoryGroupList = categoryGroupService.findAll();
        return ResponseEntity.ok(categoryGroupList.stream().map(categoryGroup -> modelMapper.map(categoryGroup,CategoryGroupDto.class)).collect(Collectors.toList()));
    }

    // Get CategoryGroup by Id
    @GetMapping("/findById/{id}")
    public ResponseEntity<CategoryGroupDto> findById(@PathVariable("id") Integer id) {
        CategoryGroup categoryGroup = categoryGroupService.findById(id);
        return ResponseEntity.ok(modelMapper.map(categoryGroup,CategoryGroupDto.class));
    }

    // Create CategoryGroup
    @PostMapping("/create")
    public ResponseEntity<CategoryGroupDto> create(@Valid @RequestBody CategoryGroupDto categoryGroupDto) {
        categoryGroupDto.setId(null);
        CategoryGroup categoryGroup = categoryGroupService.create(categoryGroupDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryGroupDto);
    }
    // Update CategoryGroup
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryGroupDto> update(@PathVariable("id") Integer id ,@Valid @RequestBody CategoryGroupDto categoryGroupDto) {
        categoryGroupDto.setId(id);
        CategoryGroup categoryGroup = categoryGroupService.update(categoryGroupDto);
        return ResponseEntity.ok(categoryGroupDto);
    }
    // Delete CategoryGroup
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        categoryGroupService.delete(id);
    }

}
