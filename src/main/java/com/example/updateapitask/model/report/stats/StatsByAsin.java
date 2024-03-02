package com.example.updateapitask.model.report.stats;

import com.example.updateapitask.model.report.OrderedProductSales;
import com.example.updateapitask.model.report.OrderedProductSalesB2B;
import lombok.Data;

@Data
public class StatsByAsin {
  private OrderedProductSales orderedProductSales;
  private OrderedProductSalesB2B orderedProductSalesB2B;
  private int totalOrderItems;
  private int totalOrderItemsB2B;
  private int unitsOrdered;
  private int unitsOrderedB2B;
  private int browserPageViews;
  private int browserPageViewsB2B;
  private double browserPageViewsPercentage;
  private int browserPageViewsPercentageB2B;
  private double browserSessionPercentage;
  private int browserSessionPercentageB2B;
  private int browserSessions;
  private int browserSessionsB2B;
  private int buyBoxPercentage;
  private int buyBoxPercentageB2B;
  private int mobileAppPageViews;
  private int mobileAppPageViewsB2B;
  private double mobileAppPageViewsPercentage;
  private int mobileAppPageViewsPercentageB2B;
  private int mobileAppSessions;
  private int mobileAppSessionsB2B;
  private int pageViews;
  private int pageViewsB2B;
  private double pageViewsPercentage;
  private int pageViewsPercentageB2B;
  private double sessionPercentage;
  private int sessionPercentageB2B;
  private int sessions;
  private int sessionsB2B;
  private double unitSessionPercentage;
  private int unitSessionPercentageB2B;
}
