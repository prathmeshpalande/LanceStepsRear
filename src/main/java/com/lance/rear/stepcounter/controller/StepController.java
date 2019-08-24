package com.lance.rear.stepcounter.controller;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.NoteStepsRequest;
import com.lance.rear.stepcounter.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StepController {

    @Autowired
    StepService stepService;

    @PostMapping("/push_steps")
    public GeneralResponseObject noteSteps(@RequestBody NoteStepsRequest noteStepsRequest) {

        GeneralResponseObject generalResponseObject = stepService.noteSteps(noteStepsRequest);

        return generalResponseObject;
    }
}
