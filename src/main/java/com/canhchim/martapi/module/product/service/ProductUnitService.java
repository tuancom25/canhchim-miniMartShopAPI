package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.entity.ProductUnit;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductUnitDto;
import com.canhchim.martapi.module.product.repositories.IProductInputRepository;
import com.canhchim.martapi.module.product.repositories.ProductUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductUnitService {
    @Autowired
    ProductUnitRepository productUnitRepository;

    @Autowired
    MappingData mappingData;

    public List<ProductUnitDto> getAllProductUnitDto (){
        List<ProductUnitDto> list = new ArrayList<ProductUnitDto>();
        for (ProductUnit p :productUnitRepository.findAll()) {
            list.add(mappingData.mappingProductUnitToDTO(p));
        }
        return list;
    }

    public ProductUnitDto addProductUnit(ProductUnitDto productUnitDto){
        return mappingData.mappingProductUnitToDTO(productUnitRepository.save(mappingData.mappingProductUnitDtoToEntity(productUnitDto)));

    }

    public ProductUnitDto updateProductUnit(ProductUnitDto productUnitDto){
        return mappingData.mappingProductUnitToDTO(productUnitRepository.save(mappingData.mappingProductUnitDtoToEntity(productUnitDto)));
    }

    public String deleteProductUnit(ProductUnitDto productUnitDto){
        if (productUnitRepository.existsById(productUnitDto.getId())){
            productUnitRepository.deleteById(productUnitDto.getId());
            return "Deleted";
        }
        return "Fail";
    }
}
