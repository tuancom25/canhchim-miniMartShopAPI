package com.canhchim.martapi.dto.category;

import com.canhchim.martapi.dto.shop.ShopDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryGroupDto implements Serializable {
    private Integer id;
    private String name;
    private Integer shopId;
    private List<CategoryDto> categoryList = new ArrayList<>();
}
