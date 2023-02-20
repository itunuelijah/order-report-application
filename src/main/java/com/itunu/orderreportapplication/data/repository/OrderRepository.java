package com.itunu.orderreportapplication.data.repository;

import com.itunu.orderreportapplication.data.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

     //   @Query("SELECT DATE_TRUNC('day', o.createdAt), COUNT(o), SUM(o.totalAmount) FROM Order o WHERE o.createdAt BETWEEN ?1 AND ?2 GROUP BY DATE_TRUNC('day', o.createdAt)")
        List<Object[]> findOrderCountsAndAmountsByDate(LocalDateTime startDate, LocalDateTime endDate);
}
