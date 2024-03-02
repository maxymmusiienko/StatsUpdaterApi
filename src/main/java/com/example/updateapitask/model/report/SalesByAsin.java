package com.example.updateapitask.model.report;

import lombok.Data;

@Data
public class SalesByAsin {
  private OrderedProductSales orderedProductSales;
  private OrderedProductSalesB2B orderedProductSalesB2B;
  private int totalOrderItems;
  private int totalOrderItemsB2B;
  private int unitsOrdered;
  private int unitsOrderedB2B;
}
