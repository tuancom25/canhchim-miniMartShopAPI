package com.canhchim.martapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_input_details")
public class ProductInputDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_input_detail_d", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_input_id", nullable = false)
    private ProductInput productInput;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "product_of_number", nullable = false)
    private Integer productOfNumber;

    @Column(name = "product_cost", nullable = false)
    private Long productCost;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductInput getProductInput() {
        return productInput;
    }

    public void setProductInput(ProductInput productInput) {
        this.productInput = productInput;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductOfNumber() {
        return productOfNumber;
    }

    public void setProductOfNumber(Integer productOfNumber) {
        this.productOfNumber = productOfNumber;
    }

    public Long getProductCost() {
        return productCost;
    }

    public void setProductCost(Long productCost) {
        this.productCost = productCost;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}