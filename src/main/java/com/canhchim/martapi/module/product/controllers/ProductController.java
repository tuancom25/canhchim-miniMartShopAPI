package com.canhchim.martapi.module.product.controllers;

import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.entity.Product;
import com.canhchim.martapi.module.product.data.requestDTO.ProductDto;
import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDto;
import com.canhchim.martapi.module.product.service.ProductService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    PermissionUtil permissionUtil ;


    // Get all product by ShopId
    @GetMapping("")
    ResponseEntity<?> getAllProduct(HttpServletRequest httpServletRequest) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        List<ProductDto> list = productService.getall(permissionUtil.getShopId(httpServletRequest));
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }


    // Create Product
    @PostMapping("/create-product")
    ResponseEntity<?> addProductType (HttpServletRequest httpServletRequest,@Valid @RequestBody ProductDto productDto) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productService.addProduct(productDto,permissionUtil.getShopId(httpServletRequest)));
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/update-product")
    ResponseEntity<?> updateProductType (HttpServletRequest httpServletRequest, @RequestBody ProductDto productDto) throws IOException {
        permissionUtil.acceptAction(httpServletRequest,"Product","shop.id","id",Math.toIntExact(productDto.getId()));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productService.updateProduct(productDto));
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/delete-product-input")
    ResponseEntity<String> deleteProductInput (HttpServletRequest httpServletRequest, @RequestBody ProductDto productDto) throws IOException {
        permissionUtil.acceptAction(httpServletRequest,"Product","shop.id","id", Math.toIntExact(productDto.getId()));
        String notification = productService.deleteProduct(productDto);
        return ResponseEntity.ok().body(notification);
    }
}
