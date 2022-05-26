/**
 * Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "functions")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FunctionId", nullable = false)
    private Integer id;

    @Column(name = "FunctionName", nullable = false, length = 60)
    private String functionName;

    @Column(name = "FunctionComment", nullable = false, length = 120)
    private String functionComment;

    @Column(name = "FunctionClass", nullable = false, length = 60)
    private String functionClass;

    @Column(name = "FunctionKey", nullable = false, length = 12)
    private String functionKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionComment() {
        return functionComment;
    }

    public void setFunctionComment(String functionComment) {
        this.functionComment = functionComment;
    }

    public String getFunctionClass() {
        return functionClass;
    }

    public void setFunctionClass(String functionClass) {
        this.functionClass = functionClass;
    }

    public String getFunctionKey() {
        return functionKey;
    }

    public void setFunctionKey(String functionKey) {
        this.functionKey = functionKey;
    }

}