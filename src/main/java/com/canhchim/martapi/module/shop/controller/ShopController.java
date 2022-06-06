// Author :Trung

package com.canhchim.martapi.module.shop.controller;

import com.canhchim.martapi.dto.shop.ShopDto;
import com.canhchim.martapi.entity.Shop;
import com.canhchim.martapi.module.shop.service.ShopService;
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
    @GetMapping("/findAll")
    public ResponseEntity<List<ShopDto>> getAllShop() {

        return ResponseEntity.ok(shopService.getAllShop());
    }
    // Get Shop by Id
    @GetMapping("/findById/{id}")
    public ResponseEntity<ShopDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(shopService.findById(id));
    }
    // Create Shop
    @PostMapping("/create")
    public ResponseEntity<ShopDto> create(@Valid @RequestBody ShopDto shopDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.create(shopDto));
    }
    // Update Shop
    @PutMapping("/update/{id}")
    public ResponseEntity<ShopDto> update(@PathVariable("id") Integer id , @Valid @RequestBody ShopDto shopDto) {
        shopDto.setId(id);
        return ResponseEntity.ok(shopService.update(shopDto));
    }
    // Delete Shop
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        shopService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
