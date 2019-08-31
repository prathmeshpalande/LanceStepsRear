package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.SignUpRequest;
import com.lance.rear.stepcounter.model.User;
import com.lance.rear.stepcounter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GeneralResponseObject login(SignUpRequest signUpRequest) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();
        try {
            User user = userRepository.checkIfUserExists(signUpRequest.getUniqueCode());
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(signUpRequest.getUniqueCode() + "_users.csv", true)));
            if(user == null) {
                printWriter.println(signUpRequest.getUniqueCode() + "," + signUpRequest.getName() + "," + 1);
                userRepository.signUp(signUpRequest.getUniqueCode(), signUpRequest.getName(), 1);
            }
            else {
                Integer signInCount = userRepository.getSignInCount(signUpRequest.getUniqueCode());
                printWriter.println(signUpRequest.getUniqueCode() + "," + signUpRequest.getName() + "," + (((signInCount != null) ? signInCount : 0) + 1));
                userRepository.updateSignInCount(signUpRequest.getUniqueCode(), ((signInCount != null) ? signInCount : 0) + 1);
                generalResponseObject = GeneralResponseObject.getFailureResponseObject();
                generalResponseObject.setResponseMessage("Duplicate Login Detected! Please contact the administrators for further information.");
            }
            printWriter.close();

        } catch(Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }

        return generalResponseObject;
    }

    public void invalidateLogin(Integer uniqueCode) {
        userRepository.invalidateLogin(uniqueCode);
    }
}
