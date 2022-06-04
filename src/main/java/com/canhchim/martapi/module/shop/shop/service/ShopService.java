package com.canhchim.martapi.module.shop.shop.service;

import com.canhchim.martapi.entity.Shop;
import com.canhchim.martapi.module.shop.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private ModelMapper modelMapper;
    // Get All Shop
    public List<Shop> getAllShop() {
        return shopRepository.findAll();
    }
    // Get Shop by Id
    public Shop getShopById(Integer id) {
        return shopRepository.findById(id).orElse(null);
    }

    // Get Shop by Name

    // Create Shop
    public Shop createShop(ShopDto shopDto) {
//        Shop shop = new Shop();
//        shop.setShopName(shopDto.getShopName());
//        shop.setShopAddressGPSLongtitude(shopDto.getShopAddressGPSLongtitude());
//        shop.setShopAddressGPSlatitude(shopDto.getShopAddressGPSlatitude());
//        shop.setShopAddressNational(shopDto.getShopAddressNational());
//        shop.setShopAddressProvinceCity(shopDto.getShopAddressProvinceCity());
//        shop.setShopAddressWards(shopDto.getShopAddressWards());
//        shop.setShopAddressStreet(shopDto.getShopAddressStreet());
//        shop.setShopAddressNationalCode(shopDto.getShopAddressNationalCode());
        System.err.println(shopDto);
        Shop shop = modelMapper.map(shopDto, Shop.class);
        System.err.println(shop);

        return shopRepository.save(shop);
    }
}
