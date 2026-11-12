package org.example.factory;

import org.example.strategy.discount.DiscountStrategy;
import org.example.strategy.discount.PremiumDiscountStrategy;
import org.example.strategy.discount.RegularDiscountStrategy;
import org.example.strategy.discount.VipDiscountStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyFactoryImpl implements DiscountStrategyFactory {

    private static final Map<String, DiscountStrategy> DISCOUNT_STRATEGIES = new HashMap<>();

    static {
        DISCOUNT_STRATEGIES.put("REGULAR", new RegularDiscountStrategy());
        DISCOUNT_STRATEGIES.put("VIP", new VipDiscountStrategy());
        DISCOUNT_STRATEGIES.put("PREMIUM", new PremiumDiscountStrategy());
    }

    @Override
    public DiscountStrategy getStrategy (String customerType) {
        DiscountStrategy strategy = DISCOUNT_STRATEGIES.get(customerType);

        if (strategy == null) {
            throw new RuntimeException("Unknown customer type: " + customerType);
        }

        return strategy;
    }
}
