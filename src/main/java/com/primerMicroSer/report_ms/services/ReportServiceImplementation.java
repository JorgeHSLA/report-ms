package com.primerMicroSer.report_ms.services;

import com.netflix.discovery.EurekaClient;
import com.primerMicroSer.report_ms.helpers.ReportHelper;
import com.primerMicroSer.report_ms.models.Company;
import com.primerMicroSer.report_ms.models.WebSite;
import com.primerMicroSer.report_ms.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImplementation implements ReportService {


    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;


    @Override
    public String makeReport(String report) {

        return reportHelper.readTemplate(companiesRepository.getByName(report).orElseThrow());

    }

    @Override
    public String saveReport(String report) {
        var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var placeholders= reportHelper.getPlaceholdersFromTemplate(report);
        var webSites = Stream.of(placeholders.get(3)).map(webSite -> WebSite.builder().name(webSite).build())
                .toList();
        var company = Company.builder()
                .name(placeholders.get(0))
                .foundationDate(LocalDate.parse(placeholders.get(1), format))
                .founder(placeholders.get(2))
                .webSites(webSites)
                .build();
        companiesRepository.postByName(company);
        return "Saved the report";
    }

    @Override
    public void deleteReport(String name) {
         companiesRepository.deleteByName(name);
    }
}
