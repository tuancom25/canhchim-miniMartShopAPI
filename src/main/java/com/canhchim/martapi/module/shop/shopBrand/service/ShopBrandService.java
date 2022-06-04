package com.canhchim.martapi.module.shop.shopBrand.service;

import com.canhchim.martapi.entity.ShopBrand;
import com.canhchim.martapi.module.shop.shopBrand.repository.ShopBrandRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ShopBrandService {
    private final ShopBrandRepository shopBrandRepository;
    private final ModelMapper modelMapper;
    // Get All ShopBrand
    public List<ShopBrand> getAllShopBrand() {
        return shopBrandRepository.findAll();
    }
    // Get ShopBrand by Id
    public ShopBrand getShopBrandById(Integer id) {
        return shopBrandRepository.findById(id).orElse(null);
    }
    // Get ShopBrand by Name

    // Create ShopBrand
    public ShopBrand createShopBrand(ShopBrandDto shopBrandDto) {
        ShopBrand shopBrand = modelMapper.map(shopBrandDto, ShopBrand.class);
        return shopBrandRepository.save(shopBrand);
    }
    // Update ShopBrand
    public ShopBrand updateShopBrand(ShopBrandDto shopBrandDto) {
        ShopBrand oldShopBrand = getShopBrandById(shopBrandDto.getId());
        oldShopBrand.setName(shopBrandDto.getName());
        return shopBrandRepository.save(oldShopBrand);
    }
    // Delete ShopBrand
    public void deleteShopBrand(Integer id) {
        shopBrandRepository.deleteById(id);
    }
}
