package com.lance.rear.stepcounter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Integer uniqueCode;

    private String name;

    private String sessionKey;


    public User() {
        super();
    }

    public User(Integer uniqueCode, String name, String sessionKey) {
        super();
        this.uniqueCode = uniqueCode;
        this.name = name;
        this.sessionKey = sessionKey;
    }
}
