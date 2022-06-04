package com.canhchim.martapi.module.shop.shop.controller;

import com.canhchim.martapi.entity.Shop;
import com.canhchim.martapi.module.shop.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    // Get All Shop
    @GetMapping("/getAllShop")
    public ResponseEntity<List<Shop>> getAllShop() {

        return ResponseEntity.ok(shopService.getAllShop());
    }
    // Get Shop by Id
    // Create Shop
    @PostMapping("/createShop")
    public ResponseEntity<ShopDto> createShop(@Valid @RequestBody ShopDto shopDto) {
        shopService.createShop(shopDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(shopDto);
    }

}
