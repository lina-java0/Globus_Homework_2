package org.example.strategy.commission;

import org.example.dto.Order;

public class CardCommissionStrategy implements CommissionStrategy {

    @Override
    public double applyCommission(Order order) {
        return order.getAmount() * 0.02;
    }
}
