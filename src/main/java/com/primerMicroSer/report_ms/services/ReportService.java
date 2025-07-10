package com.primerMicroSer.report_ms.services;

public interface ReportService {

    String makeReport(String nameReport);
    String saveReport(String nameReport);
    void deleteReport(String nameReport);
    // no habra uodate
}
