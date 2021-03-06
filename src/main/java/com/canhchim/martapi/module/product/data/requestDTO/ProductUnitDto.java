package com.canhchim.martapi.module.product.data.requestDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ProductUnitDto implements Serializable {
    private  Integer id;
    private  String name;

    public ProductUnitDto() {
    }

    public ProductUnitDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
