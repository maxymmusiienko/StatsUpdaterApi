package com.example.updateapitask.service;

import com.example.updateapitask.model.report.Report;
import com.example.updateapitask.repository.ReportRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataLoaderImpl {
  private final ReportRepository reportRepository;
  private static final Logger logger = LoggerFactory.getLogger(DataLoaderImpl.class);

  @Value("${db.document.id}")
  private String documentId;

  @Value("${loader.file.path}")
  private String filePath;

  @Autowired
  public DataLoaderImpl(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  @Scheduled(fixedRateString = "${doc.update.time}")
  public void loadData() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Report report = objectMapper.readValue(new File(filePath), Report.class);
      report.setId(documentId);
      reportRepository.save(report);
      logger.info("Data loaded successfully!");
    } catch (IOException e) {
      System.err.println("Error loading data from JSON file: " + e.getMessage());
    }
  }
}
