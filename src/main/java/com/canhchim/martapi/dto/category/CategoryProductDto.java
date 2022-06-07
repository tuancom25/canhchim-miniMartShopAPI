package com.canhchim.martapi.dto.category;

import com.canhchim.martapi.dto.shop.ShopDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProductDto implements Serializable {
    private Integer id;
    private String name;
    private Integer categoryProductParent;
    private String comment;
    private String imgLink;
    private Integer shopId;
}
