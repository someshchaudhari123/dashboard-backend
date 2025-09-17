package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class DashboardController {

    @GetMapping
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("revenue", 12000); // replace with DB query
        stats.put("orders", 50);     // replace with DB query
        stats.put("users", 20);      // replace with DB query
        stats.put("visits", 300);    // replace with DB query
        return stats;
    }
}
