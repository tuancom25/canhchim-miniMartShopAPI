package com.canhchim.martapi.module.product.controllers;


import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.module.product.data.requestDTO.ProductInputDetailDto;
import com.canhchim.martapi.module.product.data.requestDTO.ProductUnitDto;
import com.canhchim.martapi.module.product.service.ProductInputDetailService;
import com.canhchim.martapi.module.product.service.ProductUnitService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    ResponseEntity<?> getAllProductUnit(HttpServletRequest httpServletRequest,@RequestParam(value = "page", defaultValue = "0") int page,@RequestParam(value = "size", defaultValue = "10") int size ){

        ResponseDto responseDto = new ResponseDto();
        Page<ProductUnitDto> list = productUnitService.getAllProductUnitDto(page,size);
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/create-product-unit")
    ResponseEntity<ProductUnitDto> addProductUnit (HttpServletRequest httpServletRequest, @RequestBody ProductUnitDto productUnitDto){
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        ProductUnitDto responseProductUnitDto = productUnitService.addProductUnit(productUnitDto);
        return ResponseEntity.ok().body(responseProductUnitDto);
    }

    @PostMapping("/update-product-unit")
    ResponseEntity<ProductUnitDto> updateProductUnit (HttpServletRequest httpServletRequest, @RequestBody ProductUnitDto productUnitDto) {
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        ProductUnitDto responseProductUnitDto = productUnitService.updateProductUnit(productUnitDto);

        return ResponseEntity.ok().body(responseProductUnitDto);
    }

    @GetMapping("/delete-product-unit")
    ResponseEntity<String> deleteProductUnit (HttpServletRequest httpServletRequest, @RequestBody ProductUnitDto productUnitDto) throws IOException {
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        String notification = productUnitService.deleteProductUnit(productUnitDto);
        return ResponseEntity.ok().body(notification);
    }
}
