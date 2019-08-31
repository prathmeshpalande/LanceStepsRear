package com.lance.rear.stepcounter.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public String getReport(String reportType) { //reportType = users or steps
        StringBuffer reportBuffer = new StringBuffer();
        try {
            List<String> reportFiles = getReportFiles(".", reportType);
            for (String file : reportFiles) {
                String text = "";
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                if(reportType.equalsIgnoreCase("users")) {
                    String[] lineSplit = bufferedReader.readLine().split(",");
                    text = lineSplit[0] + "," + lineSplit[1];
                }
                else {
                    Map<Long, Integer> timeStepsMap = new HashMap<>();
                    String line = "";
                    while((line = bufferedReader.readLine()) != null) {
                        String[] lineSplit = line.split(",");
                        Long timeInMillisLine = Long.parseLong(lineSplit[2]);
                        Integer stepsLine = Integer.parseInt(lineSplit[1]);

                        timeStepsMap.put(timeInMillisLine, stepsLine);
                    }
                    Long totalSteps = 0L;
                    for(Map.Entry<Long, Integer> timeSteps : timeStepsMap.entrySet()) {
                        totalSteps += timeSteps.getValue();
                    }
                    text = file.split("_")[0] + "," + totalSteps + "," + LocalDate.now();

                }
                bufferedReader.close();
                reportBuffer.append(text + "\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String header = ((reportType.equalsIgnoreCase("users")) ? "uniqueCode,name" : "uniqueCode,steps,date") + "\n";
        return header + reportBuffer.toString();
    }

    List<String> getReportFiles(String directory, String reportType) {
        List<String> textFiles = new ArrayList<String>();
        File dir = new File(directory);
        for (File file : dir.listFiles()) {
            if (file.getName().toLowerCase().endsWith((reportType + ".csv"))) {
                textFiles.add(file.getName());
            }
        }
        return textFiles;
    }

}
