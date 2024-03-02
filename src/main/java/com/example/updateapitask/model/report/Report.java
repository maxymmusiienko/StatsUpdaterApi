package com.example.updateapitask.model.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("test_report")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {
  @Id
  private String id;
  private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
  private List<SalesAndTrafficByDate> salesAndTrafficByDate;
}
