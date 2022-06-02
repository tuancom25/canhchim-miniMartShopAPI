/**
 * @author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private Integer id;

    @Column(name = "Username", nullable = false, length = 60)
    private String username;

    @Column(name = "UserFullName", nullable = false, length = 60)
    private String userFullName;

    @Column(name = "UserPhone", nullable = false, length = 12)
    private String userPhone;

    @Column(name = "UserEmail", length = 60)
    private String userEmail;

    @Column(name = "UserPassword", nullable = false, length = 64)
    private String userPassword;

    @Column(name = "UserPasswordSalt", nullable = false, length = 12)
    private String userPasswordSalt;

    @Column(name = "UserPassOtp", length = 12)
    private String userPassOtp;

    @Column(name = "UserCCCD", length = 12)
    private String userCCCD;

    @Column(name = "UserAddress", length = 150)
    private String userAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserShopId")
    private Shop userShop;

    @Column(name = "UserLastTimeActive")
    private Instant userLastTimeActive;

    @Column(name = "UserDuringTime")
    private Integer userDuringTime;

    @Column(name = "UserRSAPublic", length = 512)
    private String userRSAPublic;

    @Column(name = "UserRSAPrivate", length = 1024)
    private String userRSAPrivate;

    @Column(name = "UserIPLastWork", length = 39)
    private String userIPLastWork;

    @Column(name = "UserDeviceList", length = 301)
    private String userDeviceList;

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

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPasswordSalt() {
        return userPasswordSalt;
    }

    public void setUserPasswordSalt(String userPasswordSalt) {
        this.userPasswordSalt = userPasswordSalt;
    }

    public String getUserPassOtp() {
        return userPassOtp;
    }

    public void setUserPassOtp(String userPassOtp) {
        this.userPassOtp = userPassOtp;
    }

    public String getUserCCCD() {
        return userCCCD;
    }

    public void setUserCCCD(String userCCCD) {
        this.userCCCD = userCCCD;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Shop getUserShop() {
        return userShop;
    }

    public void setUserShop(Shop userShop) {
        this.userShop = userShop;
    }

    public Instant getUserLastTimeActive() {
        return userLastTimeActive;
    }

    public void setUserLastTimeActive(Instant userLastTimeActive) {
        this.userLastTimeActive = userLastTimeActive;
    }

    public Integer getUserDuringTime() {
        return userDuringTime;
    }

    public void setUserDuringTime(Integer userDuringTime) {
        this.userDuringTime = userDuringTime;
    }

    public String getUserRSAPublic() {
        return userRSAPublic;
    }

    public void setUserRSAPublic(String userRSAPublic) {
        this.userRSAPublic = userRSAPublic;
    }

    public String getUserRSAPrivate() {
        return userRSAPrivate;
    }

    public void setUserRSAPrivate(String userRSAPrivate) {
        this.userRSAPrivate = userRSAPrivate;
    }

    public String getUserIPLastWork() {
        return userIPLastWork;
    }

    public void setUserIPLastWork(String userIPLastWork) {
        this.userIPLastWork = userIPLastWork;
    }

    public String getUserDeviceList() {
        return userDeviceList;
    }

    public void setUserDeviceList(String userDeviceList) {
        this.userDeviceList = userDeviceList;
    }

}