package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShopId", nullable = false)
    private Integer id;

    @Column(name = "ShopName", nullable = false, length = 50)
    private String shopName;

    @Column(name = "ShopAddressGPSLongtitude")
    private Double shopAddressGPSLongtitude;

    @Column(name = "ShopAddressGPSlatitude")
    private Double shopAddressGPSlatitude;

    @Column(name = "ShopAddressNational", length = 100)
    private String shopAddressNational;

    @Column(name = "ShopAddressProvinceCity", length = 100)
    private String shopAddressProvinceCity;

    @Column(name = "ShopAddressDistrict", length = 100)
    private String shopAddressDistrict;

    @Column(name = "ShopAddressWards", length = 100)
    private String shopAddressWards;

    @Column(name = "ShopAddressStreet", nullable = false, length = 50)
    private String shopAddressStreet;

    @Column(name = "ShopAddressNationalCode", length = 50)
    private String shopAddressNationalCode;

    @Column(name = "ShopAddressFull", nullable = false, length = 50)
    private String shopAddressFull;

    @Column(name = "DateTime1")
    private Instant dateTime1;

    @Column(name = "DateTime2")
    private Instant dateTime2;

    @Column(name = "ShopRSAPrivate", length = 512)
    private String shopRSAPrivate;

    @Column(name = "ShopSRAPublic", length = 1024)
    private String shopSRAPublic;

    @Column(name = "ShopKeySalt", length = 12)
    private String shopKeySalt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getShopAddressGPSLongtitude() {
        return shopAddressGPSLongtitude;
    }

    public void setShopAddressGPSLongtitude(Double shopAddressGPSLongtitude) {
        this.shopAddressGPSLongtitude = shopAddressGPSLongtitude;
    }

    public Double getShopAddressGPSlatitude() {
        return shopAddressGPSlatitude;
    }

    public void setShopAddressGPSlatitude(Double shopAddressGPSlatitude) {
        this.shopAddressGPSlatitude = shopAddressGPSlatitude;
    }

    public String getShopAddressNational() {
        return shopAddressNational;
    }

    public void setShopAddressNational(String shopAddressNational) {
        this.shopAddressNational = shopAddressNational;
    }

    public String getShopAddressProvinceCity() {
        return shopAddressProvinceCity;
    }

    public void setShopAddressProvinceCity(String shopAddressProvinceCity) {
        this.shopAddressProvinceCity = shopAddressProvinceCity;
    }

    public String getShopAddressDistrict() {
        return shopAddressDistrict;
    }

    public void setShopAddressDistrict(String shopAddressDistrict) {
        this.shopAddressDistrict = shopAddressDistrict;
    }

    public String getShopAddressWards() {
        return shopAddressWards;
    }

    public void setShopAddressWards(String shopAddressWards) {
        this.shopAddressWards = shopAddressWards;
    }

    public String getShopAddressStreet() {
        return shopAddressStreet;
    }

    public void setShopAddressStreet(String shopAddressStreet) {
        this.shopAddressStreet = shopAddressStreet;
    }

    public String getShopAddressNationalCode() {
        return shopAddressNationalCode;
    }

    public void setShopAddressNationalCode(String shopAddressNationalCode) {
        this.shopAddressNationalCode = shopAddressNationalCode;
    }

    public String getShopAddressFull() {
        return shopAddressFull;
    }

    public void setShopAddressFull(String shopAddressFull) {
        this.shopAddressFull = shopAddressFull;
    }

    public Instant getDateTime1() {
        return dateTime1;
    }

    public void setDateTime1(Instant dateTime1) {
        this.dateTime1 = dateTime1;
    }

    public Instant getDateTime2() {
        return dateTime2;
    }

    public void setDateTime2(Instant dateTime2) {
        this.dateTime2 = dateTime2;
    }

    public String getShopRSAPrivate() {
        return shopRSAPrivate;
    }

    public void setShopRSAPrivate(String shopRSAPrivate) {
        this.shopRSAPrivate = shopRSAPrivate;
    }

    public String getShopSRAPublic() {
        return shopSRAPublic;
    }

    public void setShopSRAPublic(String shopSRAPublic) {
        this.shopSRAPublic = shopSRAPublic;
    }

    public String getShopKeySalt() {
        return shopKeySalt;
    }

    public void setShopKeySalt(String shopKeySalt) {
        this.shopKeySalt = shopKeySalt;
    }

}