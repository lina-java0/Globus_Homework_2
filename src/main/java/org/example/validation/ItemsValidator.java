package org.example.validation;

import org.example.dto.Order;

public class ItemsValidator implements Validator {

    @Override
    public void validate(Order order) {
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new RuntimeException("Order must contain at least one item");
        }
    }
}
