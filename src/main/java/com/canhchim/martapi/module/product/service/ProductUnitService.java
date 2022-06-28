package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.entity.ProductSupply;
import com.canhchim.martapi.entity.ProductUnit;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductUnitDto;
import com.canhchim.martapi.module.product.repositories.IProductInputRepository;
import com.canhchim.martapi.module.product.repositories.ProductUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductUnitService {
    @Autowired
    ProductUnitRepository productUnitRepository;

    @Autowired
    MappingData mappingData;

    public Page<ProductUnitDto> getAllProductUnitDto (int page, int size){
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        Page<ProductUnit> productSupplies = productUnitRepository.findAll(pageable);
        return productSupplies.map(mappingData::mappingProductUnitToDTO);
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
