package com.example.updateapitask.service;

import com.example.updateapitask.exception.StatsException;
import com.example.updateapitask.model.report.Report;
import com.example.updateapitask.model.report.SalesAndTrafficByAsin;
import com.example.updateapitask.model.report.SalesAndTrafficByDate;
import com.example.updateapitask.repository.ReportRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl {
  private final ReportRepository reportRepository;
  @Value("${db.document.id}")
  private String documentId;

  @Autowired
  public ReportServiceImpl(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  public SalesAndTrafficByDate getStatsByDateFromDocument(String date) {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    if (report != null && !report.getSalesAndTrafficByDate().isEmpty()) {
      return report.getSalesAndTrafficByDate().stream()
          .filter(s -> s.getDate().equals(date))
          .findFirst().orElseThrow(() ->
              new StatsException("can`t load stats for date: " + date));
    }
    return null;
  }

  public SalesAndTrafficByAsin getStatsByAsinFromDocument(String asin) {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    if (report != null && !report.getSalesAndTrafficByAsin().isEmpty()) {
      return report.getSalesAndTrafficByAsin().stream()
          .filter(s -> s.getParentAsin().equals(asin))
          .findFirst().orElseThrow(() ->
              new StatsException("can`t load stats for asin: " + asin));
    }
    return null;
  }

  public List<SalesAndTrafficByDate> getAllStatsByDate() {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByDate();
  }

  public List<SalesAndTrafficByAsin> getAllStatsByAsin() {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByAsin();
  }

  public List<SalesAndTrafficByDate> getPeriodStatsByDate(String startDate, String endDate) {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByDate().stream()
        .filter(s -> s.getDate().compareTo(startDate) >= 0 && s.getDate().compareTo(endDate) <= 0)
        .collect(Collectors.toList());
  }

  public List<SalesAndTrafficByAsin> getListStatsByAsin(List<String> asins) {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByAsin().stream()
        .filter(s -> asins.contains(s.getParentAsin()))
        .collect(Collectors.toList());
  }
}
