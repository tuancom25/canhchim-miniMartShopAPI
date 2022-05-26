package com.canhchim.martapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId", nullable = false)
    private Integer id;

    @Column(name = "CustomerPhone", nullable = false, length = 12)
    private String customerPhone;

    @Column(name = "CustomerName", length = 60)
    private String customerName;

    @Column(name = "CustomerAddress", length = 120)
    private String customerAddress;

    @Column(name = "CustomerLike")
    private Integer customerLike;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerLike() {
        return customerLike;
    }

    public void setCustomerLike(Integer customerLike) {
        this.customerLike = customerLike;
    }

}