package com.canhchim.martapi.module.product.service;


import com.canhchim.martapi.entity.ProductInput;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDto;
import com.canhchim.martapi.module.product.repositories.IProductInputRepository;
import com.canhchim.martapi.module.product.repositories.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductInputService {
    @Autowired
    MappingData mappingData;

    @Autowired
    IShopRepository IShopRepository;

    @Autowired
    IProductInputRepository IProductInputRepository;

    public List<ProductInputDto> getAllProductInputDto(int shopId){
        List<ProductInput> productInputs = IProductInputRepository.findByUserInput_Shop_Id(shopId);
        List<ProductInputDto> list = new ArrayList<ProductInputDto>();
        for (ProductInput p : productInputs) {
            list.add(mappingData.mappingProductInputToDto(p));
        }
        return list;
    }

    public ProductInputDto addProductInputDto(ProductInputDto productInputDto, int shopId){
        return null;
    }
}
