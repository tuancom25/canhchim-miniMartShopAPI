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

}
