package com.example.updateapitask.model.report.stats;

import com.example.updateapitask.model.report.*;
import lombok.Data;

@Data
public class StatsByDate {
  private AverageSalesPerOrderItem averageSalesPerOrderItem;
  private AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
  private AverageSellingPrice averageSellingPrice;
  private AverageSellingPriceB2B averageSellingPriceB2B;
  private double averageUnitsPerOrderItem;
  private double averageUnitsPerOrderItemB2B;
  private ClaimsAmount claimsAmount;
  private int claimsGranted;
  private OrderedProductSales orderedProductSales;
  private OrderedProductSalesB2B orderedProductSalesB2B;
  private int ordersShipped;
  private double refundRate;
  private ShippedProductSales shippedProductSales;
  private int totalOrderItems;
  private int totalOrderItemsB2B;
  private int unitsOrdered;
  private int unitsOrderedB2B;
  private int unitsRefunded;
  private int unitsShipped;
  private int averageOfferCount;
  private int averageParentItems;
  private int browserPageViews;
  private int browserPageViewsB2B;
  private int browserSessions;
  private int browserSessionsB2B;
  private double buyBoxPercentage;
  private double buyBoxPercentageB2B;
  private int feedbackReceived;
  private int mobileAppPageViews;
  private int mobileAppPageViewsB2B;
  private int mobileAppSessions;
  private int mobileAppSessionsB2B;
  private int negativeFeedbackReceived;
  private double orderItemSessionPercentage;
  private double orderItemSessionPercentageB2B;
  private int pageViews;
  private int pageViewsB2B;
  private int receivedNegativeFeedbackRate;
  private int sessions;
  private int sessionsB2B;
  private double unitSessionPercentage;
  private int unitSessionPercentageB2B;
}
