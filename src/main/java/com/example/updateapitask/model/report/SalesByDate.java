package com.example.updateapitask.model.report;

import lombok.Data;

@Data
public class SalesByDate {
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
}
