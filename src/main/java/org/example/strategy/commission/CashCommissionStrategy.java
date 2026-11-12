package org.example.strategy.commission;

import org.example.dto.Order;

public class CashCommissionStrategy implements CommissionStrategy{

    @Override
    public double applyCommission(Order order) {
        return 0.0;
    }
}
