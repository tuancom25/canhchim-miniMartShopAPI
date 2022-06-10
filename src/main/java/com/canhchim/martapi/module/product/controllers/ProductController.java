package com.canhchim.martapi.module.product.controllers;

import com.canhchim.martapi.entity.Product;
import com.canhchim.martapi.module.product.data.requestDTO.ProductDto;
import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDto;
import com.canhchim.martapi.module.product.service.ProductService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    PermissionUtil permissionUtil ;

    @GetMapping("")
    ResponseEntity<List<ProductDto>> getAllProduct(HttpServletRequest httpServletRequest) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        List<ProductDto> list = productService.getall(permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/create-product")
    ResponseEntity<ProductDto> addProductType (HttpServletRequest httpServletRequest, @RequestBody ProductDto productDto) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        //productService.addProductInputDto(productInputDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(productService.addProduct(productDto,permissionUtil.getShopId(httpServletRequest)));
    }

    @PostMapping("/update-product")
    ResponseEntity<ProductDto> updateProductType (HttpServletRequest httpServletRequest, @RequestBody ProductDto productDto) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        productService.updateProduct(productDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(productService.addProduct(productDto,permissionUtil.getShopId(httpServletRequest)));
    }

    @PostMapping("/delete-product-input")
    ResponseEntity<String> deleteProductInput (HttpServletRequest httpServletRequest, @RequestBody ProductDto productDto) throws IOException {
        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        String notification = productService.deleteProduct(productDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(notification);
    }
}
