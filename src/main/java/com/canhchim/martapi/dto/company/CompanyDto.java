package com.canhchim.martapi.dto.company;

import com.canhchim.martapi.dto.shop.ShopDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto implements Serializable {
    private Integer id;
    private String name;
    @Null
    private Integer shopId;
}
