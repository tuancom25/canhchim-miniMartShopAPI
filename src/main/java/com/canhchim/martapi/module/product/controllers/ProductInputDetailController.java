package com.canhchim.martapi.module.product.controllers;

import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDetailDto;
import com.canhchim.martapi.module.product.service.ProductInputDetailService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product-input-detail")
public class ProductInputDetailController {
    @Autowired
    ProductInputDetailService detailService;

    @Autowired
    PermissionUtil permissionUtil ;

    @GetMapping("")
    ResponseEntity<List<ProductInputDetailDto>> getAllProductInputDetail(HttpServletRequest httpServletRequest){
        List<ProductInputDetailDto> list = detailService.getAllProductInputDetail(permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/create-product-input-detail")
    ResponseEntity<ProductInputDetailDto> addInputDetail (HttpServletRequest httpServletRequest, @RequestBody ProductInputDetailDto productInputDetailDto){
        ProductInputDetailDto productDetail = detailService.createProductDetail(productInputDetailDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(productDetail);
    }

    @PostMapping("/update-product-input-detail")
    ResponseEntity<ProductInputDetailDto> updateProductInputDetail (HttpServletRequest httpServletRequest, @RequestBody ProductInputDetailDto productInputDetailDto) throws IOException {
        //permissionUtil.acceptAction(httpServletRequest,"ProductInputDetail","shop.id","id", Math.toIntExact(productInputDetailDto.getId()));
        ProductInputDetailDto productDetail = detailService.updateProductDetail(productInputDetailDto);
        return ResponseEntity.ok().body(productDetail);
    }

    @GetMapping("/delete-product-input-detail")
    ResponseEntity<String> deleteProductInputDetail (HttpServletRequest httpServletRequest, @RequestBody ProductInputDetailDto productInputDetailDto) throws IOException {
        //permissionUtil.acceptAction(httpServletRequest,"ProductInputDetail","shop.id","id", Math.toIntExact(productInputDetailDto.getId()));
        String notification = detailService.deleteProductDetail(productInputDetailDto);
        return ResponseEntity.ok().body(notification);
    }
}
