package com.example.demo.controller;

import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class StatsController {

    @Autowired
    private OrderRepository orderRepository;

    // ✅ Get total revenue (sum of all orders)
    @GetMapping("/revenue")
    public Double getTotalRevenue() {
        return orderRepository.sumTotalAmount();
    }
}
