// Author :Trung

package com.canhchim.martapi.module.shop.service;

import com.canhchim.martapi.dto.shop.ShopDto;
import com.canhchim.martapi.entity.Shop;
import com.canhchim.martapi.module.categories.convert.Convert;
import com.canhchim.martapi.module.shop.repository.ShopRepository;
import com.canhchim.martapi.util.MessageConstants;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final Convert convert;
    private final MessagesUtils messagesUtils;
    // Get All Shop

    public List<ShopDto> getAllShop(int page, int size) {
        List<Shop> shopList = shopRepository.getPage(PageRequest.of(page,size)).toList();
        return shopList.stream().map(convert::convertShopToDto).collect(Collectors.toList());
    }
    // Get Shop by Id
    public ShopDto findById(Integer id) throws Exception {
        Optional<Shop> optionalShop = shopRepository.findById(id);
        if (!optionalShop.isPresent()) {
            throw new Exception(messagesUtils.getMessage(MessageConstants.Shop_ERROR_NOT_FOUND));
        }else {
            return convert.convertShopToDto(optionalShop.get());
        }
    }
    public Shop findShopById(Integer id) {
        return shopRepository.findById(id).orElse(null);
    }


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
