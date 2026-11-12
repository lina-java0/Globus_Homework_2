package org.example.validation;

import org.example.dto.Order;

public interface Validator {
    void validate(Order order);
}
