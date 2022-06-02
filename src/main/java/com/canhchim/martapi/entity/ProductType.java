package com.canhchim.martapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "producttypes")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductTypeId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopid", nullable = false)
    private Shop shopId;

    @Column(name = "ProductTypeCode", nullable = false)
    private Integer productTypeCode;

    @Column(name = "ProductTypeName", nullable = false, length = 60)
    private String productTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public Integer getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(Integer productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

}