package com.lance.rear.stepcounter.service;

import com.lance.rear.stepcounter.model.GeneralResponseObject;
import com.lance.rear.stepcounter.model.NoteStepsRequest;
import com.lance.rear.stepcounter.model.StepsDateModel;
import com.lance.rear.stepcounter.model.User;
import com.lance.rear.stepcounter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class StepService {

    @Autowired
    UserRepository userRepository;

    public GeneralResponseObject noteSteps(NoteStepsRequest noteStepsRequest) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(noteStepsRequest.getUniqueCode() + "_steps.csv", true)));
            for (StepsDateModel stepsDate : noteStepsRequest.getListStepsDate()) {
                    printWriter.println(noteStepsRequest.getUniqueCode() + "," + stepsDate.getSteps() + "," + stepsDate.getTimeInMillis());
                    userRepository.noteSteps(noteStepsRequest.getUniqueCode(), stepsDate.getSteps(), stepsDate.getTimeInMillis());
            }
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }
        return generalResponseObject;
    }

    public GeneralResponseObject getStepHistory(Integer uniqueCode) {

        GeneralResponseObject generalResponseObject = GeneralResponseObject.getSuccessResponseObject();

        try {
            List<StepsDateModel> listStepsDateModel = userRepository.getStepHistory(uniqueCode);
            generalResponseObject.setResponseData(listStepsDateModel);
        } catch (Exception e) {
            e.printStackTrace();
            generalResponseObject = GeneralResponseObject.getFailureResponseObject();
        }

        return generalResponseObject;

    }

    public String getStepReport() {
        StringBuffer reportBuffer = new StringBuffer();
        try {
            List<String> reportFiles = getReportFiles(".");
            for (String file : reportFiles) {
                String text = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
                reportBuffer.append(text + "\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return reportBuffer.toString();
    }

    List<String> getReportFiles(String directory) {
        List<String> textFiles = new ArrayList<String>();
        File dir = new File(directory);
        for (File file : dir.listFiles()) {
            if (file.getName().toLowerCase().endsWith((".csv"))) {
                textFiles.add(file.getName());
            }
        }
        return textFiles;
    }
}
