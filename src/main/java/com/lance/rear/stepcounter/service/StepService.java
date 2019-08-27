package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.NoteStepsRequest;
import com.lance.rear.stepcounter.model.StepsDateModel;
import com.lance.rear.stepcounter.model.User;
import com.lance.rear.stepcounter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {

    @Autowired
    UserRepository userRepository;

    public GeneralResponseObject noteSteps(NoteStepsRequest noteStepsRequest) {
        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();
            for(StepsDateModel stepsDate : noteStepsRequest.getListStepsDate())
                userRepository.noteSteps(noteStepsRequest.getUniqueCode(), stepsDate.getSteps(), stepsDate.getTimeInMillis());
        return generalResponseObject;
    }

    public GeneralResponseObject getStepHistory(Integer uniqueCode) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();

        try {
            List<StepsDateModel> listStepsDateModel = userRepository.getStepHistory(uniqueCode);
            generalResponseObject.setResponseData(listStepsDateModel);
        } catch(Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }

        return generalResponseObject;

    }
}
