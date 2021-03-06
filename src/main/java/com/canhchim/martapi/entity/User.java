package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 60)
    private String username;

    @Column(name = "fullname", nullable = false, length = 60)
    private String fullname;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "salt", nullable = false, length = 12)
    private String salt;

    @Column(name = "otp", length = 12)
    private String otp;

    @Column(name = "cccd", length = 12)
    private String cccd;

    @Column(name = "address", length = 150)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Column(name = "last_time_active")
    private Instant lastTimeActive;

    @Column(name = "during_time")
    private Integer duringTime;

    @Column(name = "public_key", length = 512)
    private String publicKey;

    @Column(name = "private_key", length = 1024)
    private String privateKey;

    @Column(name = "ip_last_work", length = 39)
    private String ipLastWork;

    @Column(name = "device_list", length = 301)
    private String deviceList;

    @Column(name = "actived", nullable = false)
    private Boolean actived = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Instant getLastTimeActive() {
        return lastTimeActive;
    }

    public void setLastTimeActive(Instant lastTimeActive) {
        this.lastTimeActive = lastTimeActive;
    }

    public Integer getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(Integer duringTime) {
        this.duringTime = duringTime;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getIpLastWork() {
        return ipLastWork;
    }

    public void setIpLastWork(String ipLastWork) {
        this.ipLastWork = ipLastWork;
    }

    public String getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(String deviceList) {
        this.deviceList = deviceList;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }

}