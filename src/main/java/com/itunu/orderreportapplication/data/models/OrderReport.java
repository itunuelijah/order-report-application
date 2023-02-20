package com.itunu.orderreportapplication.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class OrderReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private int totalOrders;

    private double totalOrderAmount;


    public OrderReport(LocalDate date, int count) {
    }

    public OrderReport(LocalDate date, int totalOrders, double totalOrderAmount) {
        this.date = date;
        this.totalOrders = totalOrders;
        this.totalOrderAmount = totalOrderAmount;
    }


    public OrderReport() {

    }
}
