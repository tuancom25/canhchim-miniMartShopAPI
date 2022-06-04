package com.canhchim.martapi.module.trung_test;

import com.canhchim.martapi.entity.CategoryGroup;
import com.canhchim.martapi.entity.Shop;
import com.canhchim.martapi.entity.ShopBrand;
import com.canhchim.martapi.entity.ShopType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "test_category")
public class TestCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_group_id", nullable = false)
    private CategoryGroup categoryGroup;

    @ManyToOne
    @JoinColumn(name = "shop_type_id", nullable = false)
    private ShopType shopType;

    @ManyToOne
    @JoinColumn(name = "shop_brand_id", nullable = false)
    private ShopBrand shopBrand;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

//    public TestCategory(String name, CategoryGroup categoryGroup, ShopType shopType, ShopBrand shopBrand) {
//        this.name = name;
//        this.categoryGroup = categoryGroup;
//        this.shopType = shopType;
//        this.shopBrand = shopBrand;
//    }
}