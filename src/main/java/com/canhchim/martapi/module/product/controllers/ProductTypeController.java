package com.canhchim.martapi.module.product.controllers;

import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.entity.ProductType;
import com.canhchim.martapi.module.product.data.MappingData;
import com.canhchim.martapi.module.product.data.requestDTO.ProductTypeDto;
import com.canhchim.martapi.module.product.service.ProductTypeService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product-type")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    PermissionUtil permissionUtil ;

    @PostMapping("/create-product-type")
    ResponseEntity<?> addProductType (HttpServletRequest httpServletRequest, @RequestBody ProductTypeDto productTypeDto) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productTypeService.addProductType(productTypeDto,permissionUtil.getShopId(httpServletRequest)));
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping ("")
    ResponseEntity<?> getAllProductType (HttpServletRequest httpServletRequest) throws IOException {
        List<ProductTypeDto> list = productTypeService.getAllProductType(permissionUtil.getShopId(httpServletRequest));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/update-product-type")
    ResponseEntity<?> updateProductType (HttpServletRequest httpServletRequest, @RequestBody ProductTypeDto productTypeDto) throws IOException {
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        //productTypeDto.setShopId(permissionUtil.getShopId(httpServletRequest));
        ProductTypeDto productType = productTypeService.update(productTypeDto,permissionUtil.getShopId(httpServletRequest));
        ResponseDto responseDto = new ResponseDto();

        if (productType == null){
            return null;
        }else {
            responseDto.setData(productType);
            return ResponseEntity.ok().body(productType);
        }
    }

    @PostMapping("/delete-product-type")
    ResponseEntity<String> deleteProductType (HttpServletRequest httpServletRequest, @RequestBody ProductTypeDto productTypeDto) throws IOException {
        permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        String notification = productTypeService.delete(productTypeDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(notification);
    }
}
