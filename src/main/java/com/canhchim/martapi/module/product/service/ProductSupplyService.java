package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.entity.ProductSupply;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductSupplyDto;
import com.canhchim.martapi.module.product.repositories.IProductSupplyRepository;
import com.canhchim.martapi.module.product.repositories.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSupplyService {
    @Autowired
    IProductSupplyRepository IProductSupplyRepository;

    @Autowired
    MappingData mappingData;

    @Autowired
    IShopRepository IShopRepository;

   public Page<ProductSupplyDto> getAllProductSupply(int shopId,int page, int size){
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<ProductSupply> productSupplies = IProductSupplyRepository.findByShop_Id(pageable,shopId);
        return productSupplies.map(mappingData::mappingProductSupplyToDto);
    }

    public ProductSupplyDto addProductSupplyDto(ProductSupplyDto productSupplyDto, int shopId){
        List<ProductSupply> productSupplies = IProductSupplyRepository.findByShop_Id(shopId);
        ProductSupply newProductSupply = null;
        boolean flag = true;
        for (ProductSupply p:productSupplies ) {
            if (productSupplyDto.getName().equals(p.getName()) && productSupplyDto.getAddress().equals(p.getAddress())){
                flag = false;
            }
        }
        if(flag){
            productSupplyDto.setShopId(shopId);
            IProductSupplyRepository.save(mappingData.mappingProductSupplyDtoToEntity(productSupplyDto));
            return productSupplyDto;
        }else return null;
    }

    public ProductSupplyDto updateProductSupplyDto(ProductSupplyDto productSupplyDto){
        ProductSupply productSupply = IProductSupplyRepository.findByNameAndAddress(productSupplyDto.getName(),productSupplyDto.getAddress()).get();
        if (productSupply != null){
            productSupply.setAddress(productSupplyDto.getAddress());
            productSupply.setName(productSupplyDto.getName());
            IProductSupplyRepository.save(mappingData.mappingProductSupplyDtoToEntity(productSupplyDto));
            return mappingData.mappingProductSupplyToDto(productSupply);
        } else return null;
    }

    public String deleteProductSupplyDto( ProductSupplyDto productSupplyDto){
        ProductSupply productSupply = IProductSupplyRepository.findByNameAndAddress(productSupplyDto.getName(),productSupplyDto.getAddress()).get();
        if (productSupply != null){
            IProductSupplyRepository.deleteById((long) productSupply.getId());
            return "Deleted";
        } else return "Not Found";
    }
}
