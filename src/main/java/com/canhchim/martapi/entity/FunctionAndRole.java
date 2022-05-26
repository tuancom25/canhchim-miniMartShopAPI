package com.canhchim.martapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "functionandrole")
public class FunctionAndRole {
    @EmbeddedId
    private FunctionAndRoleId id;

    @MapsId("functionId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FunctionId", nullable = false)
    private Function function;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RoleId", nullable = false)
    private Role role;

    public FunctionAndRoleId getId() {
        return id;
    }

    public void setId(FunctionAndRoleId id) {
        this.id = id;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}