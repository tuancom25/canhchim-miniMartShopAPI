package com.canhchim.martapi.module.product.service;

import com.canhchim.martapi.entity.Product;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductDto;
import com.canhchim.martapi.module.product.repositories.IProductInputRepository;
import com.canhchim.martapi.module.product.repositories.IProductRepository;
import com.canhchim.martapi.module.product.repositories.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    MappingData mappingData;

    @Autowired
    IShopRepository shopRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IProductInputRepository productInputRepository;

    public List<ProductDto> getall(int shopId){
        List<Product> products = productRepository.findByShop_Id(shopId);
        List<ProductDto> list = new ArrayList<>();
        for (Product p : products) {
            list.add(mappingData.mappingProductToDto(p));
        }
        return list;
    }

    public ProductDto addProduct(ProductDto productDto, int shopId){
        return mappingData.mappingProductToDto(productRepository.save(mappingData.mappingProductToDto(productDto)));
    }

    public ProductDto updateProduct(ProductDto productDto, int shopId){
        return mappingData.mappingProductToDto(productRepository.save(mappingData.mappingProductToDto(productDto)));
    }

    public String deleteProduct(ProductDto productDto, int shopId){
        if (productRepository.existsById(Math.toIntExact(productDto.getId()))){
        productRepository.deleteById(Math.toIntExact(productDto.getId()));
        return "Delete";
        }else return "fail";
    }
}
