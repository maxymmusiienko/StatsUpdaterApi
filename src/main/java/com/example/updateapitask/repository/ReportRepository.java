package com.example.updateapitask.repository;

import com.example.updateapitask.model.report.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
