package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.entity.ProductSupply;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductSupplyDto;
import com.canhchim.martapi.module.product.repositories.IProductSupplyRepository;
import com.canhchim.martapi.module.product.repositories.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

   public List<ProductSupplyDto> getAllProductSupply(int shopId){
        List<ProductSupply> productSupplies = IProductSupplyRepository.findByShop_Id(shopId);
        List<ProductSupplyDto> list = new ArrayList<ProductSupplyDto>();
        for (ProductSupply p : productSupplies) {
            list.add(mappingData.mappingProductSupplyToDto(p));
        }
        return list;
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
            return productSupplyDto;
        }else return null;
    }

    public ProductSupplyDto updateProductSupplyDto(ProductSupplyDto productSupplyDto, int shopId){
        ProductSupply productSupply = IProductSupplyRepository.findByNameAndAddress(productSupplyDto.getName(),productSupplyDto.getAddress()).get();
        if (productSupply != null && productSupply.getShop().getId() == shopId){
            productSupply.setAddress(productSupplyDto.getAddress());
            productSupply.setName(productSupplyDto.getName());
            return mappingData.mappingProductSupplyToDto(productSupply);
        } else return null;
    }

    public String deleteProductSupplyDto( int shopId, ProductSupplyDto productSupplyDto){
        ProductSupply productSupply = IProductSupplyRepository.findByNameAndAddress(productSupplyDto.getName(),productSupplyDto.getAddress()).get();
        if (productSupply != null && productSupply.getShop().getId() == shopId){
            IProductSupplyRepository.deleteById((long) productSupply.getId());
            return "Deleted";
        } else return "Not Found";
    }
}
