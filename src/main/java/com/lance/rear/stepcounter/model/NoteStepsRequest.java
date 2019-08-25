package com.lance.rear.stepcounter.model;

public class NoteStepsRequest {

    private Integer uniqueCode;
    private Integer steps;

    public NoteStepsRequest(Integer uniqueCode, Integer steps) {
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

    public Integer getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(Integer uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
}
