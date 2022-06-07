package com.canhchim.martapi.dto.shop;

import com.canhchim.martapi.dto.category.CategoryDto;
import com.canhchim.martapi.dto.category.CategoryProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto implements Serializable {
    private Integer id;
    private String name;
    private Integer gpsLong;
    private Integer gpsLat;
    private String address;
    private String brandName;
    private String publicKey;
    private String privateKey;
    private String salt;
    private Instant createdAt;
    private Instant updatedAt;
    // Foreign keys
    private Integer countryId;
    private Integer provinceId;
    private Integer districtId;
    private Integer wardId;
//    private List<CategoryDto> categoryList = new ArrayList<>();
//    private List<CategoryProductDto> categoryProductList = new ArrayList<>();
}
