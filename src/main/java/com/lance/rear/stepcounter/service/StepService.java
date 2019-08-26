package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.NoteStepsRequest;
import com.lance.rear.stepcounter.model.StepHistory;
import com.lance.rear.stepcounter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StepService {

    @Autowired
    UserRepository userRepository;

    public GeneralResponseObject noteSteps(NoteStepsRequest noteStepsRequest) {
        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();

        //TODO: Note Steps
        userRepository.noteSteps(noteStepsRequest.getUniqueCode(), noteStepsRequest.getSteps(), System.currentTimeMillis());

        return generalResponseObject;
    }

    public GeneralResponseObject getStepHistory(Integer uniqueCode) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();

        try {
            Collection<Object> collectionUserStepHistory = userRepository.getStepHistory(uniqueCode);
            generalResponseObject.setResponseData(collectionUserStepHistory);
        } catch(Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }


        return generalResponseObject;

    }
}
