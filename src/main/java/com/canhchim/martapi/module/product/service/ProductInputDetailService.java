package com.canhchim.martapi.module.product.service;



import com.canhchim.martapi.entity.ProductInputDetail;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDetailDto;
import com.canhchim.martapi.module.product.repositories.IProductInputDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductInputDetailService {
    @Autowired
    IProductInputDetailRepository productinputdetailRepositoryI;
    @Autowired
    MappingData mappingData;

    List<ProductInputDetailDto> getAllProductInputDetail(int shopId){
        List<ProductInputDetail> productTypeList = productinputdetailRepositoryI.findByProductInput_Shop_Id(shopId);
        List<ProductInputDetailDto> list = new ArrayList<ProductInputDetailDto>();

        for (ProductInputDetail p : productTypeList) {
            list.add(mappingData.mappingProductInputDetailToDTO(p));
        }

        return list;
    }

    ProductInputDetailDto createProductDetail(ProductInputDetailDto productInputDetailDto,int shopId){

        return null;
    }
}
