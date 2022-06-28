package com.canhchim.martapi.module.product.controllers;

import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.module.product.data.requestDTO.ProductDto;
import com.canhchim.martapi.module.product.service.ProductService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    PermissionUtil permissionUtil;


    // Get all product by ShopId
    @GetMapping("")
    ResponseEntity<?> getAllProduct(HttpServletRequest httpServletRequest, @RequestParam(value = "page", defaultValue = "0") int page,@RequestParam(value = "size", defaultValue = "10") int size ) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        List<ProductDto> list = productService.getall(permissionUtil.getShopId(httpServletRequest),page,size);
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }


    // Create Product
    @PostMapping("/create-product")
    ResponseEntity<?> addProduct (HttpServletRequest httpServletRequest,@Valid @RequestBody ProductDto productDto) throws Exception {

        System.out.println("");
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productService.addProduct(productDto,permissionUtil.getShopId(httpServletRequest)));
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/update-product")
    ResponseEntity<?> updateProduct (HttpServletRequest httpServletRequest, @RequestBody ProductDto productDto) throws Exception {
        //permissionUtil.acceptAction(httpServletRequest,"Product","shop.id","id",Math.toIntExact(productDto.getId()));
        System.out.println("Update controller");
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productService.updateProduct(productDto,permissionUtil.getShopId(httpServletRequest)));
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/delete-product")
    ResponseEntity<?> deleteProduct (HttpServletRequest httpServletRequest,@RequestParam int id) throws Exception {
        permissionUtil.acceptAction(httpServletRequest,"Product","shop.id","id", id);
        String notification = productService.deleteProduct(id);
        return ResponseEntity.ok().body(notification);
    }
    
    @GetMapping("/search-product")
    ResponseEntity<?> searchProduct (HttpServletRequest httpServletRequest, @RequestParam String code) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productService.searchProductByCode(code,permissionUtil.getShopId(httpServletRequest)));

        return ResponseEntity.ok().body(responseDto);
    }
}
