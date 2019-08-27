package com.lance.rear.stepcounter.model;

import java.util.List;

public class NoteStepsRequest {

    private Integer uniqueCode;

    private List<StepsDateModel> listStepsDate;

    public Integer getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(Integer uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public List<StepsDateModel> getListStepsDate() {
        return listStepsDate;
    }

    public void setListStepsDate(List<StepsDateModel> listStepsDate) {
        this.listStepsDate = listStepsDate;
    }

    public NoteStepsRequest() {
    }

    public NoteStepsRequest(Integer uniqueCode, List<StepsDateModel> listStepsDate) {
        this.uniqueCode = uniqueCode;
        this.listStepsDate = listStepsDate;
    }
}
