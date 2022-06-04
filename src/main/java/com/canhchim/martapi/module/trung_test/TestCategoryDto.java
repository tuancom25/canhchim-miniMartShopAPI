package com.canhchim.martapi.module.trung_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCategoryDto  {

    private Integer id;
    @NotNull
    private String name;
    @NotNull(message = "categoryGroup cannot be null")
    private Integer categoryGroupId;
    @NotNull(message = "shopType cannot be null")
    private Integer shopTypeId;
    @NotNull(message = "shopBrand cannot be null")
    private Integer shopBrandId;
}
