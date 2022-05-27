package com.canhchim.martapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "roleofuser")
public class RoleOfUser {
    @EmbeddedId
    private RoleOfUserId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RoleId", nullable = false)
    private Role role;

    public RoleOfUserId getId() {
        return id;
    }

    public void setId(RoleOfUserId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}