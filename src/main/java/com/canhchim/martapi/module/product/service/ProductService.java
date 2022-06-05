package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.repositories.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    @Autowired
    MappingData mappingData;

    @Autowired
    IShopRepository IShopRepository;
}
