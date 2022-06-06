package com.canhchim.martapi.module.product.data.requestDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ProductSupplyDto implements Serializable {
    private  Integer id;
    private  String name;
    private  String address;
    private  Integer shopId;

    public ProductSupplyDto() {
    }
}
