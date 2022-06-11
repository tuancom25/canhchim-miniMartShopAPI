package com.canhchim.martapi.module.product.controllers;

import com.canhchim.martapi.dto.ResponseDto;
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
    ResponseEntity<?> getAllProductInput(HttpServletRequest httpServletRequest) throws IOException {
        List<ProductInputDto> list = productInputService.getAllProductInputDto(permissionUtil.getShopId(httpServletRequest));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/create-product-input")
    ResponseEntity<?> addProductType (HttpServletRequest httpServletRequest, @RequestBody ProductInputDto productInputDto) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productInputService.addProductInputDto(productInputDto,permissionUtil.getShopId(httpServletRequest)));
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/update-product-input")
    ResponseEntity<?> updateProductType (HttpServletRequest httpServletRequest, @RequestBody ProductInputDto productInputDto) throws IOException {
        permissionUtil.acceptAction(httpServletRequest,"Product","shop.id","id", Math.toIntExact(productInputDto.getId()));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productInputService.updateProductInputDto(productInputDto));
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/delete-product-input")
    ResponseEntity<String> deleteProductInput (HttpServletRequest httpServletRequest, @RequestBody ProductInputDto productInputDto) throws IOException {
        permissionUtil.acceptAction(httpServletRequest,"Product","shop.id","id", Math.toIntExact(productInputDto.getId()));
        String notification = productInputService.deleteProductInputDto(productInputDto);
        return ResponseEntity.ok().body(notification);
    }
}
