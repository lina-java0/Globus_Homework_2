package org.example.factory;

import org.example.strategy.commission.CardCommissionStrategy;
import org.example.strategy.commission.CashCommissionStrategy;
import org.example.strategy.commission.CommissionStrategy;
import org.example.strategy.commission.TransferCommissionStrategy;

import java.util.HashMap;
import java.util.Map;

public class CommissionStrategyFactoryImpl implements CommissionStrategyFactory {

    private static final Map<String, CommissionStrategy> COMMISSION_STRATEGIES = new HashMap<>();

    static {
        COMMISSION_STRATEGIES.put("CARD", new CardCommissionStrategy());
        COMMISSION_STRATEGIES.put("CASH", new CashCommissionStrategy());
        COMMISSION_STRATEGIES.put("TRANSFER", new TransferCommissionStrategy());
    }

    @Override
    public CommissionStrategy getStrategy (String paymentType) {
        CommissionStrategy strategy = COMMISSION_STRATEGIES.get(paymentType);

        if (strategy == null) {
            throw new RuntimeException("Unknown payment type: " + paymentType);
        }

        return strategy;
    }
}
