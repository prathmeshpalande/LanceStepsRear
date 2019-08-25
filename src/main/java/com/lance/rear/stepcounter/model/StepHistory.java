package com.lance.rear.stepcounter.model;

import javax.persistence.*;

@Entity
public class StepHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stepId;

    private Integer uniqueCode;
    private Integer steps;
    private Long timeInMillis;

    public StepHistory(Integer uniqueCode, Integer steps, Long timeInMillis) {
        super();
        this.uniqueCode = uniqueCode;
        this.steps = steps;
        this.timeInMillis = timeInMillis;
    }

    public StepHistory() {
    }
}
