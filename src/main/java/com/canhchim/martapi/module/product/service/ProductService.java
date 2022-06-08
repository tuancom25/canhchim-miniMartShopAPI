package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.entity.Product;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.repositories.IProductRepository;
import com.canhchim.martapi.module.product.repositories.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ProductService {
    @Autowired
    MappingData mappingData;

    @Autowired
    IShopRepository IShopRepository;

    @Autowired
    IProductRepository productRepository;

    Page<Product> getPage(){
        //Pageable pageable = new P
        return productRepository.findAll(PageRequest.of(1,3));
    }
}
