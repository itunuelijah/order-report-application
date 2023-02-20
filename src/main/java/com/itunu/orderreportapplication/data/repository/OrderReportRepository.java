package com.itunu.orderreportapplication.data.repository;

import com.itunu.orderreportapplication.data.models.OrderReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderReportRepository extends JpaRepository<OrderReport, LocalDate> {
    List<Object[]> findOrderCountsByDate(LocalDate startDate, LocalDate orderDate);

}