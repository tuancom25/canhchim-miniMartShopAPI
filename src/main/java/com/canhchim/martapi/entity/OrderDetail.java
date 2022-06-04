package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "cost", nullable = false)
    private Long cost;

    @Column(name = "sale_of_code", length = 12)
    private String saleOfCode;

    @Column(name = "sale_off_money")
    private Double saleOffMoney;

    @Column(name = "sale_off_id")
    private Integer saleOffId;

    @Column(name = "quantily", nullable = false)
    private Integer quantily;

    @Column(name = "sale_off_type")
    private Boolean saleOffType;

    @Column(name = "sale_off_start")
    private Instant saleOffStart;

    @Column(name = "sale_off_end")
    private Instant saleOffEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getSaleOfCode() {
        return saleOfCode;
    }

    public void setSaleOfCode(String saleOfCode) {
        this.saleOfCode = saleOfCode;
    }

    public Double getSaleOffMoney() {
        return saleOffMoney;
    }

    public void setSaleOffMoney(Double saleOffMoney) {
        this.saleOffMoney = saleOffMoney;
    }

    public Integer getSaleOffId() {
        return saleOffId;
    }

    public void setSaleOffId(Integer saleOffId) {
        this.saleOffId = saleOffId;
    }

    public Integer getQuantily() {
        return quantily;
    }

    public void setQuantily(Integer quantily) {
        this.quantily = quantily;
    }

    public Boolean getSaleOffType() {
        return saleOffType;
    }

    public void setSaleOffType(Boolean saleOffType) {
        this.saleOffType = saleOffType;
    }

    public Instant getSaleOffStart() {
        return saleOffStart;
    }

    public void setSaleOffStart(Instant saleOffStart) {
        this.saleOffStart = saleOffStart;
    }

    public Instant getSaleOffEnd() {
        return saleOffEnd;
    }

    public void setSaleOffEnd(Instant saleOffEnd) {
        this.saleOffEnd = saleOffEnd;
    }

}