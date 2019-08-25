package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.NoteStepsRequest;
import com.lance.rear.stepcounter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
