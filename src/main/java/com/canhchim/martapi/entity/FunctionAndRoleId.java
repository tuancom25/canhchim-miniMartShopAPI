/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FunctionAndRoleId implements Serializable {
    private static final long serialVersionUID = -6548867625871423202L;
    @Column(name = "FunctionId", nullable = false)
    private Integer functionId;

    @Column(name = "RoleId", nullable = false)
    private Integer roleId;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FunctionAndRoleId entity = (FunctionAndRoleId) o;
        return Objects.equals(this.functionId, entity.functionId) &&
                Objects.equals(this.roleId, entity.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionId, roleId);
    }

}