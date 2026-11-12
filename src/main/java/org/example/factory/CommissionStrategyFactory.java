package org.example.factory;

import org.example.strategy.commission.CommissionStrategy;

public interface CommissionStrategyFactory {

    CommissionStrategy getStrategy(String paymentType);
}
