package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.entity.ProductType;

import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductTypeDto;
import com.canhchim.martapi.module.product.repositories.IProductTypeRepository;
import com.canhchim.martapi.module.product.repositories.IShopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    IProductTypeRepository IProductTypeRepository;

    @Autowired
    IShopRepository IShopRepository;

    @Autowired
    MappingData mappingData;

    public ProductType addProductType(ProductTypeDto productTypeDto, int shopId){
        List<ProductType> pT = IProductTypeRepository.findAll();
        ProductType newProductType = null;
        boolean flag = true;
        for (ProductType p:pT ) {
            if (p.getName().equals(productTypeDto.getProductTypeName())&& p.getCode().equals(productTypeDto.getProductTypeCode())){
                flag = false;
            }
        }
        if(flag && productTypeDto.getShopId() == shopId){
            newProductType = mappingData.mappingProductTypeDTOToEntity(productTypeDto);
            newProductType.setShop(IShopRepository.findById(shopId).get());
            System.err.println(
                    "******************************************"
                            + newProductType.getShop()
                            + newProductType.getName()
                            + newProductType.getCode());

            System.err.println(
                    "******************************************"
                            + productTypeDto.getShopId()
                            + productTypeDto.getProductTypeName()
                            + productTypeDto.getProductTypeCode());
            return IProductTypeRepository.save(newProductType);
        }else return null;
    }

    public List<ProductTypeDto> getAllProductType(int shopId){
        List<ProductType> productTypeList = IProductTypeRepository.getPage(1,PageRequest.of(0,3)).toList();
        List<ProductTypeDto> dtoList =  new ArrayList<>();
        for (ProductType p : productTypeList) {

            dtoList.add(mappingData.mappingProductTypeToDTO(p));

            System.err.println("xxxxxxxxxxxxxxxxxxxx");
            System.err.println(p.getName());
            System.err.println(p.getCode());
            System.err.println(p.getShop().getName());

        }
        return dtoList;
    }

    public ProductTypeDto update(ProductTypeDto productTypeDto , int shopId){
        // Sua lai logic
        ProductType productType = IProductTypeRepository.findById(productTypeDto.getId()).get();
        if (productType != null && productType.getShop().getId() == shopId){
            productType.setCode(productTypeDto.getProductTypeCode());
            productType.setName(productTypeDto.getProductTypeName());
            return mappingData.mappingProductTypeToDTO(IProductTypeRepository.save(productType));
        } else return null;
    }

    public String delete(ProductTypeDto productTypeDto , int shopId){
        ProductType productType = IProductTypeRepository.findByProductTypeCodeAndProductTypeName(productTypeDto.getProductTypeName(), productTypeDto.getProductTypeCode());
        if (productType != null && productType.getShop().getId() == shopId){
            IProductTypeRepository.delete(productType);
            return "DELETED";
        } else return "This ProductType is exist";
    }
}
