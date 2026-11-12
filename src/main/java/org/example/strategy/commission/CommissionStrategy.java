package org.example.strategy.commission;

import org.example.dto.Order;

public interface CommissionStrategy {
    double applyCommission(Order order);
}
