package org.example.strategy.discount;

import org.example.dto.Order;

public interface DiscountStrategy {
    double applyDiscount(Order order);
}
