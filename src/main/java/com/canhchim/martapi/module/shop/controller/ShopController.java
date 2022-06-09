// Author :Trung

package com.canhchim.martapi.module.shop.controller;

import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.dto.shop.ShopDto;
import com.canhchim.martapi.module.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;
    ResponseDto responseDto = new ResponseDto();

    // Get All Shop
    @GetMapping("/findAll")
    public ResponseEntity<?> getAllShop(@RequestParam int page,@RequestParam int size) {

        responseDto.setData(shopService.getAllShop(page,size));
        return ResponseEntity.ok(responseDto);
    }
    // Get Shop by Id
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) throws Exception {
        responseDto.setData(shopService.findById(id));
        return ResponseEntity.ok(responseDto);
    }
    // Create Shop
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ShopDto shopDto) {
        responseDto.setData(shopService.create(shopDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
    // Update Shop
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id , @Valid @RequestBody ShopDto shopDto) {
        shopDto.setId(id);
        responseDto.setData(shopService.update(shopDto));
        return ResponseEntity.ok(responseDto);
    }
    // Delete Shop
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        shopService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
