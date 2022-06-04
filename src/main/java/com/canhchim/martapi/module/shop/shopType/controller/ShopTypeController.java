package com.canhchim.martapi.module.shop.shopType.controller;

import com.canhchim.martapi.entity.ShopType;
import com.canhchim.martapi.module.shop.shopType.service.ShopTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shopType")
@RequiredArgsConstructor
public class ShopTypeController {
    private final ShopTypeService shopTypeService;

    // Get All ShopType
    @GetMapping("/getAllShopType")
    public List<ShopType> getAllShopTypes() {
        return shopTypeService.getAllShopType();
    }
    // Get ShopType by Id
    @GetMapping("/getShopTypeById/{id}")
    public ShopType getShopTypeById(@PathVariable("id") Integer id) {
        return shopTypeService.getShopTypeById(id);
    }
    // Get ShopType by Name
    // Create ShopType
    @PostMapping("/createShopType")
    public ShopType createShopType(@Valid @RequestBody ShopTypeDto shopTypeDto) {
        shopTypeDto.setId(null);
        return shopTypeService.createShopType(shopTypeDto);
    }
    // Update ShopType
    @PutMapping("/updateShopType/{id}")
    public ShopType updateShopType(@PathVariable("id") Integer id ,@Valid @RequestBody ShopTypeDto shopTypeDto) {
        shopTypeDto.setId(id);
        return shopTypeService.updateShopType(shopTypeDto);
    }
    // Delete ShopType
    @DeleteMapping("/deleteShopType/{id}")
    public void deleteShopType(@PathVariable("id") Integer id) {
        shopTypeService.deleteShopType(id);
    }
}
