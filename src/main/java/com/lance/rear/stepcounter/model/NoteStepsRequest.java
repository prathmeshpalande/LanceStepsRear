package com.lance.rear.stepcounter.model;

public class NoteStepsRequest {

    private String uniqueCode;
    private Integer steps;

    public NoteStepsRequest(String uniqueCode, Integer steps) {
        this.uniqueCode = uniqueCode;
        this.steps = steps;
    }

    public NoteStepsRequest() {
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
}
