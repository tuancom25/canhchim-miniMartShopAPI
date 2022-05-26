package com.canhchim.martapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminId", nullable = false)
    private Integer id;

    @Column(name = "AdminName", nullable = false, length = 60)
    private String adminName;

    @Column(name = "AdminPhone", length = 12)
    private String adminPhone;

    @Column(name = "AdminPassword", nullable = false, length = 64)
    private String adminPassword;

    @Column(name = "AdminPassswordSalt", nullable = false, length = 12)
    private String adminPassswordSalt;

    @Column(name = "AdminEmail", nullable = false, length = 60)
    private String adminEmail;

    @Column(name = "AdminType", nullable = false)
    private Integer adminType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPassswordSalt() {
        return adminPassswordSalt;
    }

    public void setAdminPassswordSalt(String adminPassswordSalt) {
        this.adminPassswordSalt = adminPassswordSalt;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

}