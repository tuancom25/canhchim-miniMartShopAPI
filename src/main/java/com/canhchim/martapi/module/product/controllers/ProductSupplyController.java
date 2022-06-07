package com.canhchim.martapi.module.product.controllers;


import com.canhchim.martapi.module.product.data.requestDTO.ProductSupplyDto;
import com.canhchim.martapi.module.product.service.ProductSupplyService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product-supply")
public class ProductSupplyController {
    @Autowired
    ProductSupplyService productSupplyService;

    @Autowired
    PermissionUtil permissionUtil ;

    @GetMapping("")
    ResponseEntity<List<ProductSupplyDto>> getAllProductSupply (HttpServletRequest httpServletRequest) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shopId.id","id",1);
        List<ProductSupplyDto> list = productSupplyService.getAllProductSupply(permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/create-product-supply")
    ResponseEntity<ProductSupplyDto> addProductType (HttpServletRequest httpServletRequest, @RequestBody ProductSupplyDto productSupplyDto) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shopId.id","id",1);
        //productSupplyService.addProductSupplyDto(productSupplyDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(productSupplyService.addProductSupplyDto(productSupplyDto,permissionUtil.getShopId(httpServletRequest)));
    }

    @PostMapping("/update-product-supply")
    ResponseEntity<ProductSupplyDto> updateroductType (HttpServletRequest httpServletRequest, @RequestBody ProductSupplyDto productSupplyDto ) throws IOException {
//        permissionUtil.acceptAction(httpServletRequest,"ProductType","shopId.id","id",1);
        //productSupplyService.addProductSupplyDto(productSupplyDto,permissionUtil.getShopId(httpServletRequest));
        return ResponseEntity.ok().body(productSupplyService.updateProductSupplyDto(productSupplyDto,permissionUtil.getShopId(httpServletRequest)));
    }

    @GetMapping("/delete-product-type")
    ResponseEntity<String> deleteProductType (HttpServletRequest httpServletRequest, @RequestBody ProductSupplyDto productSupplyDto) throws IOException {
        //permissionUtil.acceptAction(httpServletRequesPt,"ProductType","shopId.id","id",1);
        String notification = productSupplyService.deleteProductSupplyDto(permissionUtil.getShopId(httpServletRequest),productSupplyDto);
        return ResponseEntity.ok().body(notification);
    }
}
