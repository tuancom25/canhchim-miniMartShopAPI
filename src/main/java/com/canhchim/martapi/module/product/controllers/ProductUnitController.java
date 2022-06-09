package com.canhchim.martapi.module.product.controllers;


import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDetailDto;
import com.canhchim.martapi.module.product.data.requestDTO.ProductUnitDto;
import com.canhchim.martapi.module.product.service.ProductInputDetailService;
import com.canhchim.martapi.module.product.service.ProductUnitService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product-unit")
public class ProductUnitController {
    @Autowired
    ProductUnitService productUnitService;

    @Autowired
    PermissionUtil permissionUtil ;

    @GetMapping("")
    ResponseEntity<List<ProductUnitDto>> getAllProductInputDetail(HttpServletRequest httpServletRequest){
        List<ProductUnitDto> list = productUnitService.getAllProductUnitDto();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/create-product-unit")
    ResponseEntity<ProductUnitDto> addProductType (HttpServletRequest httpServletRequest, @RequestBody ProductUnitDto productUnitDto){
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        ProductUnitDto responseProductUnitDto = productUnitService.addProductUnit(productUnitDto);
        return ResponseEntity.ok().body(responseProductUnitDto);
    }

    @PostMapping("/update-product-unit")
    ResponseEntity<ProductUnitDto> updateProductType (HttpServletRequest httpServletRequest, @RequestBody ProductUnitDto productUnitDto) {
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        ProductUnitDto responseProductUnitDto = productUnitService.updateProductUnit(productUnitDto);

        return ResponseEntity.ok().body(responseProductUnitDto);
    }

    @GetMapping("/delete-product-unit")
    ResponseEntity<String> deleteProductInput (HttpServletRequest httpServletRequest, @RequestBody ProductUnitDto productUnitDto) throws IOException {
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        String notification = productUnitService.deleteProductUnit(productUnitDto);
        return ResponseEntity.ok().body(notification);
    }
}
