package com.itunu.orderreportapplication.web.controllers;



import com.itunu.orderreportapplication.data.models.OrderReport;
import com.itunu.orderreportapplication.data.services.OrderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/api/orders")
public class OrderReportController {

    @Autowired
    private OrderReportService orderReportService;

    @GetMapping("/report")
    public List<OrderReport> getOrderReport(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return orderReportService.generateOrderReport(startDate, endDate);
    }
}
