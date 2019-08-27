package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.SignUpRequest;
import com.lance.rear.stepcounter.model.User;
import com.lance.rear.stepcounter.repository.UserRepository;
import com.lance.rear.stepcounter.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GeneralResponseObject login(SignUpRequest signUpRequest) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();
        try {
            User user = userRepository.checkIfUserExists(signUpRequest.getUniqueCode());
            if(user == null) {
                userRepository.signUp(signUpRequest.getUniqueCode(), signUpRequest.getName(), 1);
            }
            else {
                Integer signInCount = userRepository.getSignInCount(signUpRequest.getUniqueCode());
                userRepository.updateSignInCount(signUpRequest.getUniqueCode(), ((signInCount != null) ? signInCount : 0) + 1);
                generalResponseObject = GeneralResponseObject.getFailureResponseObject();
            }

        } catch(Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }

        return generalResponseObject;
    }
}
