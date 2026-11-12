package org.example.factory;

import org.example.strategy.discount.DiscountStrategy;

public interface DiscountStrategyFactory {

    DiscountStrategy getStrategy(String customerType);
}
