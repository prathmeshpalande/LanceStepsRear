package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.NoteStepsRequest;
import org.springframework.stereotype.Service;

@Service
public class StepService {

    public GeneralResponseObject noteSteps(NoteStepsRequest noteStepsRequest) {
        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();

        //TODO: Note Steps

        return generalResponseObject;
    }
}
