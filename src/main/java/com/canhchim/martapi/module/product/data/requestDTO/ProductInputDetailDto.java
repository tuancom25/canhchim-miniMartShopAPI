package com.canhchim.martapi.module.product.data.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data

public class ProductInputDetailDto implements Serializable {
    private  Long id;
    private  Integer productOfNumber;
    private  Long productCost;

    private  Integer productInputId;
    private  Integer productId;
    private  Integer shopId;

    public ProductInputDetailDto() {
    }

    public Long getId() {
        return id;
    }

    public Integer getProductOfNumber() {
        return productOfNumber;
    }

    public Long getProductCost() {
        return productCost;
    }

    public Integer getProductInputId() {
        return productInputId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductOfNumber(Integer productOfNumber) {
        this.productOfNumber = productOfNumber;
    }

    public void setProductCost(Long productCost) {
        this.productCost = productCost;
    }

    public void setProductInputId(Integer productInputId) {
        this.productInputId = productInputId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}
