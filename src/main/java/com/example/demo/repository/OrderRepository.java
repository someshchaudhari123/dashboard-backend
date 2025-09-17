package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // ✅ Sum of all order amounts
    @Query("SELECT SUM(o.totalAmount) FROM Order o")
    Double sumTotalAmount();

    // ✅ Monthly revenue (last 6 months) using native SQL
    @Query(
            value = "SELECT TO_CHAR(o.created_at, 'YYYY-MM') AS month, SUM(o.total_amount) AS revenue " +
                    "FROM orders o " +
                    "WHERE o.created_at >= CURRENT_DATE - INTERVAL '6 months' " +
                    "GROUP BY TO_CHAR(o.created_at, 'YYYY-MM') " +
                    "ORDER BY month",
            nativeQuery = true
    )
    List<Object[]> getRevenueLast6Months();
}
