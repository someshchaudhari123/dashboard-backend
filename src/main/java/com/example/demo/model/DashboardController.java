//package com.example.demo.controller;
//
//import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/dashboard")
//@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
//public class DashboardController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @GetMapping
//    public Map<String, Object> getDashboardStats() {
//        // ⚡ Change queries according to your actual PostgreSQL tables
//
//        Double revenue = jdbcTemplate.queryForObject(
//                "SELECT COALESCE(SUM(amount), 0) FROM transactions",
//                Double.class
//        );
//
//        Integer orders = jdbcTemplate.queryForObject(
//                "SELECT COUNT(*) FROM orders",
//                Integer.class
//        );
//
//        Integer users = jdbcTemplate.queryForObject(
//                "SELECT COUNT(*) FROM users",
//                Integer.class
//        );
//
//        Integer visits = jdbcTemplate.queryForObject(
//                "SELECT COUNT(*) FROM visits",
//                Integer.class
//        );
//
//        return Map.of(
//                "revenue", revenue,
//                "orders", orders,
//                "users", users,
//                "visits", visits
//        );
//    }
//}
