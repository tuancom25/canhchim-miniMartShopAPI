package com.canhchim.martapi.module.trung_test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestCategoryController {
    private final TestCategoryService testCategoryService;

    private final ModelMapper modelMapper;

    @GetMapping("/getAllCategory")
    public List<TestCategory> getAllCategory() {
        return testCategoryService.findAll();
    }
    // Create Category
    @PostMapping("/createCategory")
    public ResponseEntity<TestCategoryDto> create(@Valid @RequestBody TestCategoryDto testCategoryDto)  {

        TestCategory testCategory = testCategoryService.create(testCategoryDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(testCategory, TestCategoryDto.class));
    }
}
