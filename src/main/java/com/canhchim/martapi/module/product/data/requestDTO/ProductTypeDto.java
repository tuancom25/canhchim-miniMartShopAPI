package com.canhchim.martapi.module.product.data.requestDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ProductTypeDto implements Serializable {
    private  Integer id;
    private  Integer shopId;
    private  Integer productTypeCode;
    private  String productTypeName;
}
