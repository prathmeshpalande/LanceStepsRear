package com.lance.rear.stepcounter.controller;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.SignUpRequest;
import com.lance.rear.stepcounter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public GeneralResponseObject login(@RequestBody SignUpRequest signUpRequest) {

        GeneralResponseObject generalResponseObject = userService.login(signUpRequest);

        return generalResponseObject;
    }

    @GetMapping("invalidate_login/{uniqueCode}")
    public void invalidatelogin(@PathVariable("uniqueCode") Integer uniqueCode) {
        userService.invalidateLogin(uniqueCode);
    }
}
