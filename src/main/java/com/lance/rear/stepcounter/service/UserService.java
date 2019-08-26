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
        Map<Object, Object> responseData = null;
        String sessionKey = MD5Util.getMd5("" + signUpRequest.getUniqueCode() + System.currentTimeMillis());
        try {
            User user = userRepository.checkIfUserExists(signUpRequest.getUniqueCode());
            if(user == null)
                userRepository.signUp(signUpRequest.getUniqueCode(), signUpRequest.getName(), sessionKey, 1);
            else {
                Integer signInCount = userRepository.getSignInCount(signUpRequest.getUniqueCode());
                userRepository.updateSession(signUpRequest.getUniqueCode(), sessionKey, ((signInCount != null) ? signInCount : 0) + 1);
            }
            responseData = new HashMap<>();
            responseData.put("sessionKey", sessionKey);
            generalResponseObject.setResponseData(responseData);
        } catch(Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }

        return generalResponseObject;
    }
}
