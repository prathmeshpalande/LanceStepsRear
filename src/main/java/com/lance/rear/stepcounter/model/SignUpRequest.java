package com.lance.rear.stepcounter.model;

public class SignUpRequest {

    private Integer uniqueCode;
    private String name;

    public SignUpRequest() {

    }

    public SignUpRequest(Integer uniqueCode, String name) {
        this.uniqueCode = uniqueCode;
        this.name = name;
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
}
