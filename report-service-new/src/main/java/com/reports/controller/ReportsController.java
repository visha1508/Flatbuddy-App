package com.reports.controller;

import com.reports.dto.FlatReportDto;
import com.reports.dto.UserReportDto;
import com.reports.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@CrossOrigin("*")
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    @GetMapping("/users")
    public List<UserReportDto> getUserReports() {
        return reportsService.getAllUserReports();
    }

    @GetMapping("/flats")
    public List<FlatReportDto> getFlatReports() {
        return reportsService.getAllFlatReports();
    }
}
