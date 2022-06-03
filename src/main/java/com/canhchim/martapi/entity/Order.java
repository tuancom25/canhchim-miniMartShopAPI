package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId", nullable = false)
    private Integer id;

    @Column(name = "OrderCode", length = 40)
    private String orderCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @Column(name = "OrderDate1", length = 40)
    private String orderDate1;

    @Column(name = "OrderDate2")
    private Integer orderDate2;

    @Column(name = "OrderTotalMoney", precision = 10)
    private BigDecimal orderTotalMoney;

    @Column(name = "OrderMoneyType")
    private Integer orderMoneyType;

    @Column(name = "OrderGetMoney")
    private Integer orderGetMoney;

    @Column(name = "OrderRejectMoney")
    private Integer orderRejectMoney;

    @Column(name = "OrderCustomerName", length = 60)
    private String orderCustomerName;

    @Column(name = "OrderCutomerPhone", length = 13)
    private String orderCutomerPhone;

    @Column(name = "OrderStatusPay")
    private Integer orderStatusPay;

    @Column(name = "OrderStatusShip")
    private Integer orderStatusShip;

    @Column(name = "OrderStatusShipComment", nullable = false, length = 120)
    private String orderStatusShipComment;

    @Column(name = "OrderType")
    private Integer orderType;

    @Column(name = "OrderPayType")
    private Integer orderPayType;

    @Column(name = "CusstomerAdrress", length = 120)
    private String cusstomerAdrress;

    @Column(name = "CustomerAddress2", length = 120)
    private String customerAddress2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShopId")
    private Shop shop;

    @Column(name = "ShipperId")
    private Integer shipperId;

    @Column(name = "ShippComapnyId")
    private Integer shippComapnyId;

    @Column(name = "TableZoneId")
    private Integer tableZoneId;

    @Column(name = "TableCount")
    private Integer tableCount;

    @Column(name = "CustomerCount")
    private Integer customerCount;

    @Column(name = "CustomerExpand")
    private Integer customerExpand;

    @Column(name = "OrderTableCode")
    private Integer orderTableCode;

    @Column(name = "OrderDayIndex")
    private Integer orderDayIndex;

    @Column(name = "OrderComment", length = 120)
    private String orderComment;

    @Column(name = "OrderPrintCounter", length = 120)
    private String orderPrintCounter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderDate1() {
        return orderDate1;
    }

    public void setOrderDate1(String orderDate1) {
        this.orderDate1 = orderDate1;
    }

    public Integer getOrderDate2() {
        return orderDate2;
    }

    public void setOrderDate2(Integer orderDate2) {
        this.orderDate2 = orderDate2;
    }

    public BigDecimal getOrderTotalMoney() {
        return orderTotalMoney;
    }

    public void setOrderTotalMoney(BigDecimal orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }

    public Integer getOrderMoneyType() {
        return orderMoneyType;
    }

    public void setOrderMoneyType(Integer orderMoneyType) {
        this.orderMoneyType = orderMoneyType;
    }

    public Integer getOrderGetMoney() {
        return orderGetMoney;
    }

    public void setOrderGetMoney(Integer orderGetMoney) {
        this.orderGetMoney = orderGetMoney;
    }

    public Integer getOrderRejectMoney() {
        return orderRejectMoney;
    }

    public void setOrderRejectMoney(Integer orderRejectMoney) {
        this.orderRejectMoney = orderRejectMoney;
    }

    public String getOrderCustomerName() {
        return orderCustomerName;
    }

    public void setOrderCustomerName(String orderCustomerName) {
        this.orderCustomerName = orderCustomerName;
    }

    public String getOrderCutomerPhone() {
        return orderCutomerPhone;
    }

    public void setOrderCutomerPhone(String orderCutomerPhone) {
        this.orderCutomerPhone = orderCutomerPhone;
    }

    public Integer getOrderStatusPay() {
        return orderStatusPay;
    }

    public void setOrderStatusPay(Integer orderStatusPay) {
        this.orderStatusPay = orderStatusPay;
    }

    public Integer getOrderStatusShip() {
        return orderStatusShip;
    }

    public void setOrderStatusShip(Integer orderStatusShip) {
        this.orderStatusShip = orderStatusShip;
    }

    public String getOrderStatusShipComment() {
        return orderStatusShipComment;
    }

    public void setOrderStatusShipComment(String orderStatusShipComment) {
        this.orderStatusShipComment = orderStatusShipComment;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(Integer orderPayType) {
        this.orderPayType = orderPayType;
    }

    public String getCusstomerAdrress() {
        return cusstomerAdrress;
    }

    public void setCusstomerAdrress(String cusstomerAdrress) {
        this.cusstomerAdrress = cusstomerAdrress;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public Integer getShippComapnyId() {
        return shippComapnyId;
    }

    public void setShippComapnyId(Integer shippComapnyId) {
        this.shippComapnyId = shippComapnyId;
    }

    public Integer getTableZoneId() {
        return tableZoneId;
    }

    public void setTableZoneId(Integer tableZoneId) {
        this.tableZoneId = tableZoneId;
    }

    public Integer getTableCount() {
        return tableCount;
    }

    public void setTableCount(Integer tableCount) {
        this.tableCount = tableCount;
    }

    public Integer getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(Integer customerCount) {
        this.customerCount = customerCount;
    }

    public Integer getCustomerExpand() {
        return customerExpand;
    }

    public void setCustomerExpand(Integer customerExpand) {
        this.customerExpand = customerExpand;
    }

    public Integer getOrderTableCode() {
        return orderTableCode;
    }

    public void setOrderTableCode(Integer orderTableCode) {
        this.orderTableCode = orderTableCode;
    }

    public Integer getOrderDayIndex() {
        return orderDayIndex;
    }

    public void setOrderDayIndex(Integer orderDayIndex) {
        this.orderDayIndex = orderDayIndex;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getOrderPrintCounter() {
        return orderPrintCounter;
    }

    public void setOrderPrintCounter(String orderPrintCounter) {
        this.orderPrintCounter = orderPrintCounter;
    }

}