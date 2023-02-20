package com.itunu.orderreportapplication.data.services;


import com.itunu.orderreportapplication.data.models.OrderReport;

import java.time.LocalDate;
import java.util.List;

public interface OrderReportService {

    void processOrderCreationPayload(String payload);

    List<OrderReport> generateOrderReport(LocalDate startDate, LocalDate endDate);
}