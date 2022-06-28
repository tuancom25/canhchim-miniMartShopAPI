package com.canhchim.martapi.module.product.controllers;


import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.module.product.data.requestDTO.ProductSupplyDto;
import com.canhchim.martapi.module.product.service.ProductSupplyService;
import com.canhchim.martapi.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    ResponseEntity<?> getAllProductSupply (HttpServletRequest httpServletRequest,@RequestParam(value = "page", defaultValue = "0") int page,
                                                                @RequestParam(value = "size", defaultValue = "10") int size) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        Page<ProductSupplyDto> list = productSupplyService.getAllProductSupply(permissionUtil.getShopId(httpServletRequest),page,size);
        responseDto.setData(list);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/create-product-supply")
    ResponseEntity<ProductSupplyDto> addProductSupply (HttpServletRequest httpServletRequest, @RequestBody ProductSupplyDto productSupplyDto) throws IOException {

        return ResponseEntity.ok().body(productSupplyService.addProductSupplyDto(productSupplyDto,permissionUtil.getShopId(httpServletRequest)));
    }

    @PostMapping("/update-product-supply")
    ResponseEntity<ProductSupplyDto> updateProductSupply (HttpServletRequest httpServletRequest, @RequestBody ProductSupplyDto productSupplyDto ) throws IOException {
        //permissionUtil.acceptAction(httpServletRequest,"ProductSupply","shop.id","id",productSupplyDto.getId());
        return ResponseEntity.ok().body(productSupplyService.updateProductSupplyDto(productSupplyDto));
    }

    @PostMapping("/delete-product-supply")
    ResponseEntity<String> deleteProductSupply (HttpServletRequest httpServletRequest, @RequestBody ProductSupplyDto productSupplyDto) throws IOException {
        //permissionUtil.acceptAction(httpServletRequest,"ProductType","shop.id","id",1);
        String notification = productSupplyService.deleteProductSupplyDto(productSupplyDto);
        return ResponseEntity.ok().body(notification);
    }
}
