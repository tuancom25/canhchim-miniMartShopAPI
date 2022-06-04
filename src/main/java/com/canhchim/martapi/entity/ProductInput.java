package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "product_inputs")
public class ProductInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_input_id", nullable = false)
    private Long id;

    @Column(name = "total_money", nullable = false)
    private Long totalMoney;

    @Column(name = "input_date1", nullable = false)
    private Instant inputDate1;

    @Column(name = "input_date2", nullable = false)
    private Integer inputDate2;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_input", nullable = false)
    private User userInput;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supply_id", nullable = false)
    private ProductSupply supply;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Instant getInputDate1() {
        return inputDate1;
    }

    public void setInputDate1(Instant inputDate1) {
        this.inputDate1 = inputDate1;
    }

    public Integer getInputDate2() {
        return inputDate2;
    }

    public void setInputDate2(Integer inputDate2) {
        this.inputDate2 = inputDate2;
    }

    public User getUserInput() {
        return userInput;
    }

    public void setUserInput(User userInput) {
        this.userInput = userInput;
    }

    public ProductSupply getSupply() {
        return supply;
    }

    public void setSupply(ProductSupply supply) {
        this.supply = supply;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}