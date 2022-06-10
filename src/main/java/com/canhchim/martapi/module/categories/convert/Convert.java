// Author :Trung
package com.canhchim.martapi.module.categories.convert;


import com.canhchim.martapi.dto.category.CategoryDto;
import com.canhchim.martapi.dto.category.CategoryGroupDto;
import com.canhchim.martapi.dto.category.CategoryProductDto;
import com.canhchim.martapi.dto.company.CompanyDto;
import com.canhchim.martapi.dto.shop.ShopDto;
import com.canhchim.martapi.entity.*;
import com.canhchim.martapi.module.address.country.CountryRepository;
import com.canhchim.martapi.module.address.district.DistrictRepository;
import com.canhchim.martapi.module.address.province.ProvinceRepository;
import com.canhchim.martapi.module.address.ward.WardRepository;
import com.canhchim.martapi.module.categories.categoryGroup.repo.CategoryGroupRepository;
import com.canhchim.martapi.module.company.repository.CompanyRepository;
import com.canhchim.martapi.module.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Convert {
    private final CategoryGroupRepository categoryroupRepository;
    private final ShopRepository shopRepository;

    private final CountryRepository countryRepository;
    private final ProvinceRepository provinceRepository;
    private final WardRepository wardRepository;
    private final DistrictRepository districtRepository;

    private final CompanyRepository companyRepository;


        public CategoryDto convertCategoryToDto(Category category) {
            return new CategoryDto(category.getId(),
                    category.getName(),
                    category.getCategoryParent(),
                    category.getCategoryGroup().getId(),
                    category.getComment(),
                    category.getImageLink(),
                    category.getShop().getId());
        }
        public Category convertCategoryDtoToEntity(CategoryDto categoryDto) {
            return new Category(categoryDto.getId(),
                    categoryDto.getName(),
                    categoryDto.getCategoryParent(),
                    categoryroupRepository.findById(categoryDto.getCategoryGroupId()).orElse(null),
                    categoryDto.getComment(),categoryDto.getImageLink(),
                    shopRepository.findById(categoryDto.getShopId()).orElse(null)
            );
        }
        public CategoryProductDto convertCategoryProductToDto(CategoryProduct categoryProduct) {
            return new CategoryProductDto(categoryProduct.getId(),
                    categoryProduct.getName(),
                    categoryProduct.getCategoryProductParent(),
                    categoryProduct.getComment(),
                    categoryProduct.getImgLink(),
                    categoryProduct.getShop().getId());
        }
        public CategoryProduct convertCategoryProductDtoToEntity(CategoryProductDto categoryProductDto) {
            return new CategoryProduct(categoryProductDto.getId(),
                    categoryProductDto.getName(),
                    categoryProductDto.getCategoryProductParent(),
                    categoryProductDto.getComment(),
                    categoryProductDto.getImgLink(),
                    shopRepository.findById(categoryProductDto.getShopId()).orElse(null));
        }
        public Shop convertShopDtoToEntity(ShopDto shopDto) {
            return new Shop(shopDto.getId(),
                    shopDto.getName(),
                    shopDto.getGpsLong(),
                    shopDto.getGpsLat(),
                    countryRepository.findById(shopDto.getCountryId()).orElse(null),
                    provinceRepository.findById(shopDto.getProvinceId()).orElse(null),
                    districtRepository.findById(shopDto.getDistrictId()).orElse(null),
                    wardRepository.findById(shopDto.getWardId()).orElse(null),
                    shopDto.getAddress(),
                    shopDto.getBrandName(),
                    shopDto.getPublicKey(),
                    shopDto.getPrivateKey(),
                    shopDto.getSalt(),
                    shopDto.getCreatedAt(),
                    shopDto.getUpdatedAt()
                    );
        }
        public ShopDto convertShopToDto(Shop shop) {
            return new ShopDto(shop.getId(),
                    shop.getName(),
                    shop.getGpsLong(),
                    shop.getGpsLat(),
                    shop.getAddress(),
                    shop.getBrandName(),
                    shop.getPublicKey(),
                    shop.getPrivateKey(),
                    shop.getSalt(),
                    shop.getCreatedAt(),
                    shop.getUpdatedAt(),
                    shop.getCountry().getId(),
                    shop.getProvince().getId(),
                    shop.getDistrict().getId(),
                    shop.getWard().getId()
            );
        }
        public Company convertCompanyDtoToEntity(CompanyDto companyDto) {
            return new Company(companyDto.getId(),
                    companyDto.getName(),
                    shopRepository.findById(companyDto.getShopId()).orElse(null)
            );
        }
        public CompanyDto convertCompanyToDto(Company company) {
            return new CompanyDto(company.getId(),
                    company.getName(),
                    company.getShop().getId()
            );
        }
        public CategoryGroup convertCategoryGroupDtoToEntity(CategoryGroupDto categoryGroupDto) {
            return new CategoryGroup(categoryGroupDto.getId(),
                    categoryGroupDto.getName(),
                    shopRepository.findById(categoryGroupDto.getShopId()).orElse(null)
            );
        }
        public CategoryGroupDto convertCategoryGroupToDto(CategoryGroup categoryGroup) {
            return new CategoryGroupDto(categoryGroup.getId(),
                    categoryGroup.getName(),
                    categoryGroup.getShop().getId()
            );
        }


}