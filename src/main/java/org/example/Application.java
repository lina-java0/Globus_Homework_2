package org.example;

import org.example.dto.Order;
import org.example.factory.CommissionStrategyFactoryImpl;
import org.example.factory.DiscountStrategyFactoryImpl;
import org.example.printer.ReceiptPrinter;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.example.validation.AmountValidator;
import org.example.validation.ItemsValidator;
import org.example.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Validator> validators = Arrays.asList(
                new AmountValidator(),
                new ItemsValidator()
        );

        OrderService service = new OrderService(
                validators,
                new DiscountStrategyFactoryImpl(),
                new CommissionStrategyFactoryImpl(),
                new OrderRepository(),
                new ReceiptPrinter()
        );

        Order order1 = new Order("1", "VIP", "CARD", List.of("Laptop", "Mouse"), 1000.0);
        Order order2 = new Order("2", "REGULAR", "CASH", List.of("Book"), 20.0);

        System.out.println("Final amount 1: " + service.processOrder(order1));
        System.out.println("Final amount 2: " + service.processOrder(order2));
    }
}