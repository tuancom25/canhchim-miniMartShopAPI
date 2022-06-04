package com.canhchim.martapi.module.shop.shopType.service;

import com.canhchim.martapi.entity.ShopType;
import com.canhchim.martapi.module.shop.shopType.repository.ShopTypeRepository;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopTypeService {
    private final ShopTypeRepository shopTypeRepository;
    private final ModelMapper modelMapper;
    private final MessagesUtils messagesUtils;
    // Get All ShopType
    public List<ShopType> getAllShopType() {
        return shopTypeRepository.findAll();
    }
    // Get ShopType by Id
    public ShopType getShopTypeById(Integer id) {
        return shopTypeRepository.findById(id).orElse(null);
    }

    // Get ShopType by Name
//    public ShopType getShopTypeByName(String name) throws Exception {
//        Optional<ShopType> optionalShopType = shopTypeRepository.findByName(name);
//        if (!optionalShopType.isPresent()) {
//            throw new Exception(messagesUtils.getMessage(MessageConstants.MESSAGE_CATEGORY_Product_NOT_FOUND));
//        }
//        return optionalShopType.get();
//    }


    // Create ShopType
     public ShopType createShopType(ShopTypeDto shopTypeDto) {
        ShopType shopType = modelMapper.map(shopTypeDto, ShopType.class);
//        ShopType shopType = new ShopType();
//        shopType.setShopTypeName(shopTypeDto.getShopTypeName());
        return shopTypeRepository.save(shopType);
     }
    // Update ShopType
    public ShopType updateShopType(ShopTypeDto shopTypeDto) {
        ShopType oldShopType = getShopTypeById(shopTypeDto.getId());
        oldShopType.setName(shopTypeDto.getName());
        return shopTypeRepository.save(oldShopType);
    }
    // Delete ShopType
    public void deleteShopType(Integer id) {
        shopTypeRepository.deleteById(id);
    }
}
