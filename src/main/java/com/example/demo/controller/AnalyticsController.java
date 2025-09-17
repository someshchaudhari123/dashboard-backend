package com.example.demo.controller;

import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/revenue")
    public Map<String, Object> getRevenueAnalytics() {
        Map<String, Object> response = new HashMap<>();

        // All-time revenue
        Double totalRevenue = orderRepository.sumTotalAmount();
        response.put("totalRevenue", totalRevenue != null ? totalRevenue : 0.0);

        // Revenue last 6 months grouped by month
        List<Object[]> revenueData = orderRepository.getRevenueLast6Months();
        List<Map<String, Object>> monthlyRevenue = new ArrayList<>();

        for (Object[] row : revenueData) {
            Map<String, Object> data = new HashMap<>();
            data.put("month", (String) row[0]);   // e.g. "2025-04"
            data.put("revenue", (Double) row[1]); // e.g. 25000.0
            monthlyRevenue.add(data);
        }

        response.put("monthlyRevenue", monthlyRevenue);

        return response;
    }
}
