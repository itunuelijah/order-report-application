package com.itunu.orderreportapplication.services.OrderReportApplicationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itunu.orderreportapplication.data.models.Order;

import com.itunu.orderreportapplication.data.repository.OrderRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderReportApplicationTests {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<Object, String> kafkaTemplate;
    private final MockMvc mockMvc;

    public OrderReportApplicationTests(ObjectMapper objectMapper, MockMvc mockMvc, KafkaTemplate<Object, String> kafkaTemplate1, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate1;
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper;
        this.mockMvc = mockMvc;

    }



    @Test
    public void testCreateOrder() throws Exception {
        Order order = new Order();
        order.setOrderId(1L);
        order.setCustomerName("Adeolu Ola");
        order.setPrice(BigDecimal.valueOf(100_000_000));
        order.setOrderDate(LocalDateTime.now());

        String json = objectMapper.writeValueAsString(order);
        kafkaTemplate.sendDefault(json);

        Thread.sleep(1000);

        Optional<Order> savedOrder = orderRepository.findById(1L);
        assertTrue(savedOrder.isPresent());
        assertEquals(order, savedOrder.get());
    }


}

