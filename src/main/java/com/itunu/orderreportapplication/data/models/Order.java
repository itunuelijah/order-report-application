package com.itunu.orderreportapplication.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String customerName;
    private String customerPhoneNumber;
    private String productName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;

}

