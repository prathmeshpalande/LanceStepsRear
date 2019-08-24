package com.lance.rear.stepcounter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Integer uniqueCode;
    private String name;
    private Integer steps;


    public User(Integer uniqueCode, String name, Integer steps) {
        super();
        this.uniqueCode = uniqueCode;
        this.name = name;
        this.steps = steps;
    }

    public User() {
        super();
    }

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

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }
}
