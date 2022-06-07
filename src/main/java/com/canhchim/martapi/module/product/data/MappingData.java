package com.canhchim.martapi.module.product.data;

import com.canhchim.martapi.entity.*;


import com.canhchim.martapi.module.product.data.requestDTO.*;

import com.canhchim.martapi.module.product.repositories.*;
import com.canhchim.martapi.module.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarNameProvider;

@Component
public class MappingData {
    @Autowired
    IProductTypeRepository IProductTypeRepository;

    @Autowired
    IProductInputDetailRepository productinputdetailRepositoryI;

    @Autowired
    IProductRepository IProductRepository;
    @Autowired
    IProductInputRepository productinputRepositoryI;

    @Autowired
    IProductSupplyRepository iProductSupplyRepository;

    @Autowired
    IProductUnitRepository iProductUnitRepository;

    @Autowired
    IShopRepository IShopRepository;

    @Autowired
    IUserRepository userRepository;
    public ProductType mappingProductTypeDTOToEntity(ProductTypeDto productTypeDto){
        ProductType p = new ProductType();
        p.setId(productTypeDto.getId());
        p.setName(productTypeDto.getProductTypeName());
        p.setCode(productTypeDto.getProductTypeCode());
        p.setShop(IShopRepository.findById(productTypeDto.getShopId()).get());
        return p;
    }

    public ProductTypeDto mappingProductTypeToDTO(ProductType productType){
        ProductTypeDto p = new ProductTypeDto();
        p.setId(productType.getId());
        p.setProductTypeName(productType.getName());
        p.setProductTypeCode(productType.getCode());
        p.setShopId(productType.getShop().getId());
        return p;
    }

    public ProductInputDetail mappingProductInputDetailDTOToEntity(ProductInputDetailDto dto){
        ProductInputDetail entity = new ProductInputDetail();

        entity.setId(dto.getId());
        entity.setProductCost(dto.getProductCost());
        entity.setProductOfNumber(dto.getProductOfNumber());

        entity.setProduct(IProductRepository.findById(dto.getProductId()).get());
        entity.setProductInput(productinputRepositoryI.findById(dto.getProductInputId()).get());
        entity.setShop(IShopRepository.findById(dto.getShopId()).get());


        return entity;
    }

    public ProductInputDetailDto mappingProductInputDetailToDTO(ProductInputDetail entity){
        ProductInputDetailDto dto = new ProductInputDetailDto();

        dto.setId(entity.getId());
        dto.setProductCost(entity.getProductCost());
        dto.setProductOfNumber(entity.getProductOfNumber());

        dto.setProductId(Math.toIntExact(entity.getProduct().getId()));
        dto.setProductInputId(Math.toIntExact(entity.getProductInput().getId()));
        dto.setShopId(entity.getShop().getId());

        return dto;
    }

    public ProductUnitDto mappingProductUnitToDTO(ProductUnit entity){
        ProductUnitDto dto = new ProductUnitDto();
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        return dto;
    }

    public ProductUnit mappingProductUnitDtoToEntity(ProductUnitDto dto){
        ProductUnit entity = new ProductUnit();
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        return entity;
    }

    public ProductSupply mappingProductSupplyDtoToEntity(ProductSupplyDto dto){
        ProductSupply entity = new ProductSupply();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setShop(IShopRepository.findById(dto.getShopId()).get());
        entity.setAddress(dto.getAddress());
        return  entity;
    }

    public ProductSupplyDto mappingProductSupplyToDto(ProductSupply entity){
        ProductSupplyDto dto = new ProductSupplyDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setShopId(entity.getShop().getId());
        dto.setAddress(entity.getAddress());
        return dto;
    }
    public ProductInput mappingProductInputDtoToEntity(ProductInputDto dto){
        ProductInput entity = new ProductInput();
        entity.setId(dto.getId());
        //entity.setInputDate1(dto.getInputDate1());
//        Calendar now = Calendar.getInstance().get(Calendar.YEAR);
        Integer date2 = Calendar.getInstance().get(Calendar.YEAR)*10000 + Calendar.getInstance().get(Calendar.MONTH)*100 + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        entity.setInputDate2(date2);
        entity.setShop(IShopRepository.findById(dto.getShopId()).get());
        entity.setSupply(iProductSupplyRepository.findById(dto.getSupplyId()).get());
        entity.setUserInput(userRepository.findById(dto.getUserInputId()).get());
        entity.setTotalMoney(dto.getTotalMoney());
        return entity;
    }

    public ProductInputDto mappingProductInputToDto(ProductInput entity){
        ProductInputDto dto = new ProductInputDto();
        dto.setId(entity.getId());
        //dto.setInputDate1(entity.getInputDate1());
        dto.setInputDate2(entity.getInputDate2());
        dto.setShopId(entity.getShop().getId());
        dto.setSupplyId(entity.getSupply().getId());
        dto.setUserInputId(entity.getUserInput().getId());
        dto.setTotalMoney(entity.getTotalMoney());
        return dto;
    }

//    public ProductUnit mappingProductUnitDtoToEntity(ProductUnitDto dto){
//        ProductUnit entity = new ProductUnit();
//        entity.setName(dto.getName());
//        entity.setId(dto.getId());
//        return entity;
//    }
}
