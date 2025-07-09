package com.primerMicroSer.report_ms.services;

import com.netflix.discovery.EurekaClient;
import com.primerMicroSer.report_ms.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImplementation implements ReportService {


    private final CompaniesRepository companiesRepository;


    @Override
    public String makeReport(String nameReport) {
        return companiesRepository.getbyName(nameReport).orElseThrow().getName();

    }

    @Override
    public String saveReport(String nameReport) {
        return "";
    }

    @Override
    public void deleteReport(String nameReport) {

    }
}
