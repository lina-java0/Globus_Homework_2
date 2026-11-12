package org.example.strategy.discount;

import org.example.dto.Order;

public class RegularDiscountStrategy implements DiscountStrategy{

    @Override
    public double applyDiscount(Order order) {
        return 0.0;
    }
}
