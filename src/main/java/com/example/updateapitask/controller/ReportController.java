package com.example.updateapitask.controller;

import com.example.updateapitask.model.report.SalesAndTrafficByDate;
import com.example.updateapitask.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {
  private final ReportServiceImpl reportService;

  @Autowired
  public ReportController(ReportServiceImpl reportService) {
    this.reportService = reportService;
  }

  @GetMapping
  @RequestMapping("/{date}")
  public SalesAndTrafficByDate getStatsByDate(@PathVariable String date) {
    return reportService.getSalesByDateFromDocument(date);
  }
}
