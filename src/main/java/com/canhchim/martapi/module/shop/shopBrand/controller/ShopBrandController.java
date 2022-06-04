package com.canhchim.martapi.module.shop.shopBrand.controller;

import com.canhchim.martapi.entity.ShopBrand;
import com.canhchim.martapi.module.shop.shopBrand.service.ShopBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shopBrand")
@RequiredArgsConstructor
public class ShopBrandController {
    private final ShopBrandService shopBrandService;
    // Get All ShopBrand
    @GetMapping("/getAllShopBrand")
    public List<ShopBrand> getAllShopBrand() {
        return shopBrandService.getAllShopBrand();
    }
    // Get ShopBrand by Id
    @GetMapping("/getShopBrandById/{id}")
    public ShopBrand getShopBrandById(@PathVariable("id") Integer id) {
        return shopBrandService.getShopBrandById(id);
    }
    // Get ShopBrand by Name

    // Create ShopBrand
    @PostMapping("/createShopBrand")
    public ShopBrand createShopBrand(@Valid @RequestBody ShopBrandDto shopBrandDto) {
        shopBrandDto.setId(null);
        return shopBrandService.createShopBrand(shopBrandDto);
    }
    // Update ShopBrand
    @PutMapping("/updateShopBrand/{id}")
    public ShopBrand updateShopBrand(@PathVariable("id") Integer id, @Valid @RequestBody ShopBrandDto shopBrandDto) {
        shopBrandDto.setId(id);
        return shopBrandService.updateShopBrand(shopBrandDto);
    }
    // Delete ShopBrand
    @DeleteMapping("/deleteShopBrand/{id}")
    public void deleteShopBrand(@PathVariable("id") Integer id) {
        shopBrandService.deleteShopBrand(id);
    }
}
