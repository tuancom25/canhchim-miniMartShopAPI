// Author :Trung

package com.canhchim.martapi.module.shop.service;

import com.canhchim.martapi.dto.shop.ShopDto;
import com.canhchim.martapi.entity.Shop;
import com.canhchim.martapi.module.categories.convert.Convert;
import com.canhchim.martapi.module.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final Convert convert;
    // Get All Shop
    public List<ShopDto> getAllShop() {
        List<Shop> shopList = shopRepository.findAll();
        return shopList.stream().map(convert::convertShopToDto).collect(Collectors.toList());
    }
    // Get Shop by Id
    public ShopDto findById(Integer id) {
        Shop shop = shopRepository.findById(id).orElse(null);
        assert shop != null;
        return convert.convertShopToDto(shop);
    }
    public Shop findShopById(Integer id) {
        return shopRepository.findById(id).orElse(null);
    }



    // Get Shop by Name

    // Create Shop
    public ShopDto create(ShopDto shopDto) {
        Shop shop = convert.convertShopDtoToEntity(shopDto);
        return shopDto;
    }
    // Update Shop
    public ShopDto update(ShopDto shopDto) {
        Shop oldShop = findShopById(shopDto.getId());
        oldShop =  shopRepository.save(convert.convertShopDtoToEntity(shopDto));
        return shopDto;
    }
    // Delete Shop
    public void delete(Integer id) {
        shopRepository.deleteById(id);
    }
}
