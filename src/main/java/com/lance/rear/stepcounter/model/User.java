package com.lance.rear.stepcounter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Integer uniqueCode;

    private String name;


    public User(Integer uniqueCode, String name) {
        super();
        this.uniqueCode = uniqueCode;
        this.name = name;
    }

    public User() {
        super();
    }
}
