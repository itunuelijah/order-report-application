package com.itunu.orderreportapplication.data.repository;

import com.itunu.orderreportapplication.data.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findByProductId(Long productId);
}