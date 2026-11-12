package org.example.strategy.discount;

import org.example.dto.Order;

public class PremiumDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(Order order) {
        return order.getAmount() * 0.10;
    }
}
