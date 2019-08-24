package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public GeneralResponseObject signUp(SignUpRequest signUpRequest) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();

        //TODO: Perform signup


        return generalResponseObject;
    }
}
