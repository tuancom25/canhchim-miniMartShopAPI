package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 12)
    private String code;

    @Column(name = "type", nullable = false)
    private Boolean type = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supply_id", nullable = false)
    private ProductSupply supply;

    @Column(name = "input_date", nullable = false)
    private Instant inputDate;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_input", nullable = false)
    private User userInput;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_last_update", nullable = false)
    private User userLastUpdate;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @Column(name = "avatar", length = 256)
    private String avatar;

    @Column(name = "product_parent")
    private Long productParent;

    @Column(name = "sale_status")
    private Integer saleStatus;

    @Column(name = "has_top_up")
    private Integer hasTopUp;

    @Column(name = "is_top_up")
    private Integer isTopUp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_unit_id", nullable = false)
    private ProductUnit productUnit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductSupply getSupply() {
        return supply;
    }

    public void setSupply(ProductSupply supply) {
        this.supply = supply;
    }

    public Instant getInputDate() {
        return inputDate;
    }

    public void setInputDate(Instant inputDate) {
        this.inputDate = inputDate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public User getUserInput() {
        return userInput;
    }

    public void setUserInput(User userInput) {
        this.userInput = userInput;
    }

    public User getUserLastUpdate() {
        return userLastUpdate;
    }

    public void setUserLastUpdate(User userLastUpdate) {
        this.userLastUpdate = userLastUpdate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getProductParent() {
        return productParent;
    }

    public void setProductParent(Long productParent) {
        this.productParent = productParent;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getHasTopUp() {
        return hasTopUp;
    }

    public void setHasTopUp(Integer hasTopUp) {
        this.hasTopUp = hasTopUp;
    }

    public Integer getIsTopUp() {
        return isTopUp;
    }

    public void setIsTopUp(Integer isTopUp) {
        this.isTopUp = isTopUp;
    }

    public ProductUnit getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}