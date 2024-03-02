package com.example.updateapitask.service;

import com.example.updateapitask.exception.StatsException;
import com.example.updateapitask.model.report.Report;
import com.example.updateapitask.model.report.SalesAndTrafficByAsin;
import com.example.updateapitask.model.report.SalesAndTrafficByDate;
import com.example.updateapitask.repository.ReportRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl {
  private final ReportRepository reportRepository;
  @Value("${db.document.id}")
  private String documentId;

  private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

  @Autowired
  public ReportServiceImpl(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  @CacheEvict(value = {"statsByDateFromDocument", "statsByAsinFromDocument",
      "allStatsByDate", "allStatsByAsin",
      "periodStatsByDate", "listStatsByAsin"}, allEntries = true)
  @Scheduled(fixedRateString = "${caching.update.time}")
  public void emptyDocumentCache() {
    logger.info("emptying Document cache");
  }

  @Cacheable("statsByDateFromDocument")
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

  @Cacheable("statsByAsinFromDocument")
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

  @Cacheable("allStatsByDate")
  public List<SalesAndTrafficByDate> getAllStatsByDate() {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByDate();
  }

  @Cacheable("allStatsByAsin")
  public List<SalesAndTrafficByAsin> getAllStatsByAsin() {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByAsin();
  }

  @Cacheable("periodStatsByDate")
  public List<SalesAndTrafficByDate> getPeriodStatsByDate(String startDate, String endDate) {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByDate().stream()
        .filter(s -> s.getDate().compareTo(startDate) >= 0 && s.getDate().compareTo(endDate) <= 0)
        .collect(Collectors.toList());
  }

  @Cacheable("listStatsByAsin")
  public List<SalesAndTrafficByAsin> getListStatsByAsin(List<String> asins) {
    Report report = reportRepository.findById(documentId)
        .orElseThrow(() -> new StatsException("can`t find report by id: " + documentId));
    return report.getSalesAndTrafficByAsin().stream()
        .filter(s -> asins.contains(s.getParentAsin()))
        .collect(Collectors.toList());
  }
}
