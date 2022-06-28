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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<ProductDto> getall(int shopId, int page , int size ){
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> products = productRepository.findByShop_IdAndIsDeleted(shopId,false,pageable);

        List<ProductDto> list = new ArrayList<>();

        for (Product p : products.toList()) {
            list.add(mappingData.mappingProductToDto(p));
        }
        return list;
    }

    public ProductDto addProduct(ProductDto productDto, int shopId) throws Exception {
        ProductDto response = null;

        Optional<Product> find = productRepository.findByCodeAndShop_Id(productDto.getCode(),shopId);
        Product product = new Product();

        if (!find.isPresent() || (find.get().getCode().equals(productDto.getCode()) && find.get().getIsDeleted())){
            productDto.setId(null);
            productDto.setShopId(shopId);
            product = mappingData.mappingProductToEntity(productDto);
            product.setIsDeleted(false);
            response = mappingData.mappingProductToDto(productRepository.save(product));
            return response;
        }else  {
            throw new Exception("Sản Phẩm Này Đã Tồn Tại");
        }
    }

    public ProductDto updateProduct(ProductDto productDto, int shopId) throws Exception {
        System.out.println("Update service");
        ProductDto response = null;
        productDto.setShopId(shopId);
        Optional<Product> find = productRepository.findByIdAndShop_IdAndIsDeleted(productDto.getId(),shopId,false);

        if (find.isPresent()){
            response = mappingData.mappingProductToDto(productRepository.save(mappingData.mappingProductToEntity(productDto)));
            return response;
        }else {
            throw new Exception("Sản Phẩm Chưa Tồn Tại");
        }
    }

    public String deleteProduct(int id) throws Exception {
        // Check lai sau
        Optional<Product> find = productRepository.findById(id);
        if (find.isPresent() && find.get().getIsDeleted()){
            productRepository.deleteById(id);
            return "Delete";
        }else throw new Exception("Khong tim thay san pham tuong ung!");
    }

    public Page<ProductDto> searchProductByCode(String code, int shopId) throws Exception {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(0, 1, sort);
        Page<Product> page = productRepository.findByCodeAndShop_Id(pageable,code,shopId);

        Optional<Product> find = productRepository.findByCodeAndShop_Id(code,shopId);
        if (find.isPresent()){
            return page.map(mappingData::mappingProductToDto);
        }else {
            throw new Exception("Khong tim thay san pham tuong ung!");
        }
    }
}
