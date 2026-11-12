package org.example.validation;

import org.example.dto.Order;

public class AmountValidator implements Validator {

    @Override
    public void validate(Order order) {
        if (order.getAmount() <= 0) {
            throw new RuntimeException("Order amount must be positive");
        }
    }
}
