package com.lance.rear.stepcounter.controller;

import com.lance.rear.stepcounter.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping(value = "report/{reportType}", produces = "text/csv")
    public ResponseEntity getReport(@PathVariable("reportType") String reportType) {
        String stepReport = reportService.getReport(reportType);

        // Parses the date
        LocalDate dt = LocalDate.now();
        // Function call
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_YYYY");
        String date = formatter.format(dt);
        String fileName = "report_" + reportType + "_" + date + ".csv";
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            printWriter.println(stepReport);
            printWriter.close();

            File file = new File(fileName);

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + fileName)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("text/csv"))
                    .body(new FileSystemResource(file));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to generate report: " + "report_", e);
        }
    }
}
