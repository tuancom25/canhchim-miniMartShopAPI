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
    IProductInputDetailRepository productInputDetailRepository;
    @Autowired
    MappingData mappingData;

    public List<ProductInputDetailDto> getAllProductInputDetail(int shopId){
        List<ProductInputDetail> productTypeList = productInputDetailRepository.findByProductInput_Shop_Id(shopId);
        List<ProductInputDetailDto> list = new ArrayList<ProductInputDetailDto>();
        for (ProductInputDetail p : productTypeList) {
            list.add(mappingData.mappingProductInputDetailToDTO(p));
        }
        return list;
    }

    public ProductInputDetailDto createProductDetail(ProductInputDetailDto productInputDetailDto,int shopId){
        productInputDetailDto.setShopId(shopId);
        if (productInputDetailRepository.existsByProductInput_Id(Long.valueOf(productInputDetailDto.getProductInputId()))){
            return mappingData.mappingProductInputDetailToDTO(productInputDetailRepository.save(mappingData.mappingProductInputDetailDTOToEntity(productInputDetailDto)));
        }else {
            return null;
        }
    }

    public ProductInputDetailDto updateProductDetail(ProductInputDetailDto productInputDetailDto){
        return mappingData.mappingProductInputDetailToDTO(productInputDetailRepository.save(mappingData.mappingProductInputDetailDTOToEntity(productInputDetailDto)));
    }

    public String deleteProductDetail(ProductInputDetailDto productInputDetailDto){
        if (productInputDetailRepository.existsById(productInputDetailDto.getId())){
            productInputDetailRepository.deleteById(productInputDetailDto.getId());
        }else return "Deleted";
        return "Fail";
    }
}
