package com.lance.rear.stepcounter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Integer uniqueCode;

    private String name;

    private String sessionKey;

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

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
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

    public User(Integer uniqueCode, String name, String sessionKey, Integer signInCount) {
        super();
        this.uniqueCode = uniqueCode;
        this.name = name;
        this.sessionKey = sessionKey;
        this.signInCount = signInCount;
    }
}
