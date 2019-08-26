package com.lance.rear.stepcounter.model;

public class StepsDateModel {

    private Integer steps;
    private Long timeInMillis;

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(Long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public StepsDateModel() {
    }

    public StepsDateModel(Integer steps, Long timeInMillis) {
        this.steps = steps;
        this.timeInMillis = timeInMillis;
    }
}
