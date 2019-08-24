package com.lance.rear.stepcounter.controller;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.SignUpRequest;
import com.lance.rear.stepcounter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public GeneralResponseObject signUp(@RequestBody SignUpRequest signUpRequest) {

        GeneralResponseObject generalResponseObject = userService.signUp(signUpRequest);

        return generalResponseObject;
    }
}
