package com.example.updateapitask.service;

import com.example.updateapitask.model.report.Report;
import com.example.updateapitask.model.report.SalesAndTrafficByDate;
import com.example.updateapitask.model.report.SalesByDate;
import com.example.updateapitask.repository.ReportRepository;
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

  public SalesAndTrafficByDate getSalesByDateFromDocument(String date) {
    Report report = reportRepository.findById(documentId).orElseThrow(RuntimeException::new);
    if (report != null && !report.getSalesAndTrafficByDate().isEmpty()) {
      return report.getSalesAndTrafficByDate().stream()
          .filter(s -> s.getDate().equals(date))
          .findFirst().orElseThrow(RuntimeException::new);
    }
    return null;
  }
}
