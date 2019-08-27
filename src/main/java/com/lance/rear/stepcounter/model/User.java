package com.lance.rear.stepcounter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Integer uniqueCode;

    private String name;

    private Integer signInCount;


    public Integer getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(Integer uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public User() {
        super();
    }

    public User(Integer uniqueCode, String name, Integer signInCount) {
        super();
        this.uniqueCode = uniqueCode;
        this.name = name;
        this.signInCount = signInCount;
    }
}
