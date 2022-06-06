package com.canhchim.martapi.module.product.data.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ProductInputDto implements Serializable {
    private  Long id;
    private  Long totalMoney;
    private  Instant inputDate1;
    private  Integer inputDate2;
    private  Integer userInputId;
    private  Integer supplyId;
    private  Integer shopId;

    public ProductInputDto() {
    }
}
