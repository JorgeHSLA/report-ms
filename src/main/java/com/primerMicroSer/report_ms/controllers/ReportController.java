package com.primerMicroSer.report_ms.controllers;


import com.primerMicroSer.report_ms.services.ReportService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "report")
@AllArgsConstructor
public class ReportController {

    private ReportService reportService;
    @GetMapping(path = "{name}")
    public ResponseEntity<Map<String,String>> getReport(@PathVariable String name){
        var response = Map.of("report",this.reportService.makeReport(name));
        return ResponseEntity.ok(response);
    }
}
