package com.canhchim.martapi.module.product.controllers;

import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDto;
import com.canhchim.martapi.module.product.service.ProductInputService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product-input")
public class ProductInputController {
    @Autowired
    ProductInputService productInputService;
    @Autowired
    PermissionUtil permissionUtil ;
    @GetMapping("")
    ResponseEntity<List<ProductInputDto>> getAllProductInput(HttpServletRequest httpServletRequest) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        List<ProductInputDto> list = productInputService.getAllProductInputDto(permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/create-product-input")
    ResponseEntity<ProductInputDto> addProductType (HttpServletRequest httpServletRequest, @RequestBody ProductInputDto productInputDto) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        productInputService.addProductInputDto(productInputDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(productInputService.addProductInputDto(productInputDto,permissionUtil.getShopId(httpServletRequest)));
    }

    @PostMapping("/update-product-input")
    ResponseEntity<ProductInputDto> updateProductType (HttpServletRequest httpServletRequest, @RequestBody ProductInputDto productInputDto) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        productInputService.updateProductInputDto(productInputDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(productInputService.addProductInputDto(productInputDto,permissionUtil.getShopId(httpServletRequest)));
    }

    @PostMapping("/delete-product-input")
    ResponseEntity<String> deleteProductInput (HttpServletRequest httpServletRequest, @RequestBody ProductInputDto productInputDto) throws IOException {
        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        String notification = productInputService.deleteProductInputDto(productInputDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(notification);
    }
}
