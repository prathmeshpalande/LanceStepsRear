package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.SignUpRequest;
import com.lance.rear.stepcounter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GeneralResponseObject login(SignUpRequest signUpRequest) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();

        //TODO: Perform signup
        try {
            userRepository.signUp(signUpRequest.getUniqueCode(), signUpRequest.getName());
        } catch(Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }

        return generalResponseObject;
    }
}
