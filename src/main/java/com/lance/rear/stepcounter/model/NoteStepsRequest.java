package com.lance.rear.stepcounter.model;

import java.util.List;

public class NoteStepsRequest {

    private String sessionKey;

    private List<StepsDateModel> listStepsDate;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public List<StepsDateModel> getListStepsDate() {
        return listStepsDate;
    }

    public void setListStepsDate(List<StepsDateModel> listStepsDate) {
        this.listStepsDate = listStepsDate;
    }

    public NoteStepsRequest() {
    }

    public NoteStepsRequest(String sessionKey, List<StepsDateModel> listStepsDate) {
        this.sessionKey = sessionKey;
        this.listStepsDate = listStepsDate;
    }
}
