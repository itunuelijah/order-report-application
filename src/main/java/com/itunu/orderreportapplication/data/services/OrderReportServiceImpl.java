package com.itunu.orderreportapplication.data.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itunu.orderreportapplication.data.models.Order;
import com.itunu.orderreportapplication.data.models.OrderReport;
import com.itunu.orderreportapplication.data.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderReportServiceImpl implements OrderReportService {

      OrderRepository orderRepository;

     private  ObjectMapper  objectMapper;

    public OrderReportServiceImpl(OrderRepository orderRepository, ObjectMapper objectMapper) {
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void processOrderCreationPayload(String payload) {
        try {
            Order order = objectMapper.readValue(payload, Order.class);
            orderRepository.save(order);
        } catch (IOException e) {
        }
    }

    @Override
    public List<OrderReport> generateOrderReport(LocalDate startDate, LocalDate endDate) {
        List<Object[]> rows = orderRepository.findOrderCountsAndAmountsByDate(startDate.atStartOfDay(), endDate.atStartOfDay().plusDays(1));
        List<OrderReport> orderReports = new ArrayList<>();
        for (Object[] row : rows) {
            LocalDate date = ((Timestamp) row[0]).toLocalDateTime().toLocalDate();
            int count = ((Number) row[1]).intValue();
            double amount = ((Number) row[2]).doubleValue();
            OrderReport orderReport = new OrderReport(date, count, amount);
            orderReports.add(orderReport);
        }
        return orderReports;
    }
}
