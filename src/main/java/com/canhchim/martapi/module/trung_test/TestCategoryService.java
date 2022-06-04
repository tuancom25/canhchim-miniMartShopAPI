package com.canhchim.martapi.module.trung_test;

import com.canhchim.martapi.module.categoryGroup.service.CategoryGroupService;
import com.canhchim.martapi.module.shop.shopBrand.service.ShopBrandService;
import com.canhchim.martapi.module.shop.shopType.service.ShopTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestCategoryService  {
    private final TestCategoryRepository testCategoryRepository;
    private final ModelMapper modelMapper;
    private final ShopBrandService shopBrandService;
    private final ShopTypeService shopTypeService;
    private final CategoryGroupService categoryGroupService;
    // Get All Category

    // Create Category
//    public TestCategory createCategory(TestCategoryDto testCategoryDto) {
//
//            TestCategory testCategory = modelMapper.map(testCategoryDto, TestCategory.class);
//            System.err.println(testCategory);
//            System.out.println(testCategoryDto);
//            return testCategoryRepository.save(testCategory);
//
//
//
//    }


    public List<TestCategory> findAll() {
        return testCategoryRepository.findAll();
    }

    // Create
    public TestCategory create(TestCategoryDto testCategoryDto)  {

        TestCategory testCategory = modelMapper.map(testCategoryDto, TestCategory.class);
        testCategory.setCategoryGroup(categoryGroupService.getCategoryGroupById(testCategoryDto.getCategoryGroupId()));
        testCategory.setShopType(shopTypeService.getShopTypeById(testCategoryDto.getShopTypeId()));
        testCategory.setShopBrand(shopBrandService.getShopBrandById(testCategoryDto.getShopBrandId()));
        return testCategoryRepository.save(testCategory);

    }

//    public TestCategory createCategory(@NotNull TestCategoryDto testCategoryDto) {
//        TestCategory testCategory = new TestCategory();
//        testCategory.setTestCategoryName(testCategoryDto.getTestCategoryName());
//        testCategory.setCategoryGroup(testCategoryDto.getCategoryGroup());
//        testCategory.setShopBrand(testCategoryDto.getShopBrand());
//        testCategory.setShopType(testCategoryDto.getShopType());
//        return testCategoryRepository.save(testCategory);
//    }
}
