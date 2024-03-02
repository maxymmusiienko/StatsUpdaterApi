package com.example.updateapitask.controller;

import com.example.updateapitask.model.report.SalesAndTrafficByAsin;
import com.example.updateapitask.model.report.SalesAndTrafficByDate;
import com.example.updateapitask.service.ReportServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  @RequestMapping("/date/{date}")
  public SalesAndTrafficByDate getStatsByDate(@PathVariable String date) {
    return reportService.getStatsByDateFromDocument(date);
  }

  @GetMapping
  @RequestMapping("/asin/{asin}")
  public SalesAndTrafficByAsin getStatsByAsin(@PathVariable String asin) {
    return reportService.getStatsByAsinFromDocument(asin);
  }

  @GetMapping
  @RequestMapping("/date")
  public List<SalesAndTrafficByDate> getAllStatsByDate() {
    return reportService.getAllStatsByDate();
  }

  @GetMapping
  @RequestMapping("/asin")
  public List<SalesAndTrafficByAsin> getAllStatsByAsin() {
    return reportService.getAllStatsByAsin();
  }

  @GetMapping("/date/period")
  public List<SalesAndTrafficByDate> getPeriodStatsByDate(@RequestParam String startDate,
                                                          @RequestParam String endDate) {
    return reportService.getPeriodStatsByDate(startDate, endDate);
  }

  @GetMapping("/asin/list")
  public List<SalesAndTrafficByAsin> getListStatsByAsin(@RequestParam List<String> asins) {
    return reportService.getListStatsByAsin(asins);
  }
}
