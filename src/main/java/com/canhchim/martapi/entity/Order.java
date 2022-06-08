package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(name = "order_code", nullable = false, length = 40)
    private String orderCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date1", nullable = false, length = 40)
    private String date1;

    @Column(name = "date2", nullable = false)
    private Instant date2;

    @Column(name = "total_money", nullable = false)
    private Integer totalMoney;

    @Column(name = "money_type", nullable = false)
    private Integer moneyType;

    @Column(name = "get_money", nullable = false)
    private Integer getMoney;

    @Column(name = "reject_money", nullable = false)
    private Integer rejectMoney;

    @Column(name = "customer_name", length = 60)
    private String customerName;

    @Column(name = "customer_phone", length = 12)
    private String customerPhone;

    @Column(name = "status_pay", nullable = false)
    private Integer statusPay;

    @Column(name = "status_ship")
    private Integer statusShip;

    @Column(name = "status_ship_comment", length = 120)
    private String statusShipComment;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "pay_type", nullable = false)
    private Integer payType;

    @Column(name = "customer_adrress", length = 120)
    private String customerAdrress;

    @Column(name = "customer_adrress2", length = 120)
    private String customerAdrress2;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_company_id")
    private ShipCompany shipCompany;

    @Column(name = "order_comment", length = 120)
    private String orderComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public Instant getDate2() {
        return date2;
    }

    public void setDate2(Instant date2) {
        this.date2 = date2;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

    public Integer getGetMoney() {
        return getMoney;
    }

    public void setGetMoney(Integer getMoney) {
        this.getMoney = getMoney;
    }

    public Integer getRejectMoney() {
        return rejectMoney;
    }

    public void setRejectMoney(Integer rejectMoney) {
        this.rejectMoney = rejectMoney;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(Integer statusPay) {
        this.statusPay = statusPay;
    }

    public Integer getStatusShip() {
        return statusShip;
    }

    public void setStatusShip(Integer statusShip) {
        this.statusShip = statusShip;
    }

    public String getStatusShipComment() {
        return statusShipComment;
    }

    public void setStatusShipComment(String statusShipComment) {
        this.statusShipComment = statusShipComment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getCustomerAdrress() {
        return customerAdrress;
    }

    public void setCustomerAdrress(String customerAdrress) {
        this.customerAdrress = customerAdrress;
    }

    public String getCustomerAdrress2() {
        return customerAdrress2;
    }

    public void setCustomerAdrress2(String customerAdrress2) {
        this.customerAdrress2 = customerAdrress2;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public ShipCompany getShipCompany() {
        return shipCompany;
    }

    public void setShipCompany(ShipCompany shipCompany) {
        this.shipCompany = shipCompany;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

}