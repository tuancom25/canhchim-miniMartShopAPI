package com.canhchim.martapi.module.product.data.requestDTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data

public class ProductDto implements Serializable {
    private  Long id;
    private  String code;
    private  Boolean type;
    private  Integer categoryId;
    private  String name;
    private  Long price;
    private  Integer quantity;
    private  Integer supplyId;
    private  Instant inputDate;
    private  Instant lastUpdate;
    private  Integer userInputId;
    private  Integer userLastUpdateId;
    private  Boolean status;
    private  String avatar;
    private  Long productParent;
    private  Integer saleStatus;
    private  Integer hasTopUp;
    private  Integer isTopUp;
    private  Integer productUnitId;
    private  Integer shopId;

    public ProductDto() {
    }

    public ProductDto(Long id, String code, Boolean type, Integer categoryId, String name, Long price, Integer quantity, Integer supplyId, Instant inputDate, Instant lastUpdate, Integer userInputId, Integer userLastUpdateId, Boolean status, String avatar, Long productParent, Integer saleStatus, Integer hasTopUp, Integer isTopUp, Integer productUnitId, Integer shopId) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplyId = supplyId;
        this.inputDate = inputDate;
        this.lastUpdate = lastUpdate;
        this.userInputId = userInputId;
        this.userLastUpdateId = userLastUpdateId;
        this.status = status;
        this.avatar = avatar;
        this.productParent = productParent;
        this.saleStatus = saleStatus;
        this.hasTopUp = hasTopUp;
        this.isTopUp = isTopUp;
        this.productUnitId = productUnitId;
        this.shopId = shopId;
    }
}
