package org.example.service;

import org.example.dto.Order;
import org.example.factory.CommissionStrategyFactory;
import org.example.factory.DiscountStrategyFactory;
import org.example.printer.ReceiptPrinter;
import org.example.repository.OrderRepository;
import org.example.strategy.commission.CommissionStrategy;
import org.example.strategy.discount.DiscountStrategy;
import org.example.validation.Validator;

import java.util.List;

public class OrderService {

    private final List<Validator> validators;
    private final DiscountStrategyFactory discountStrategyFactory;
    private final CommissionStrategyFactory commissionStrategyFactory;
    private final OrderRepository repository;
    private final ReceiptPrinter printer;

    public OrderService(List<Validator> validators,
                        DiscountStrategyFactory discountStrategyFactory,
                        CommissionStrategyFactory commissionStrategyFactory,
                        OrderRepository repository,
                        ReceiptPrinter printer) {
        this.validators = List.copyOf(validators);
        this.discountStrategyFactory = discountStrategyFactory;
        this.commissionStrategyFactory = commissionStrategyFactory;
        this.repository = repository;
        this.printer = printer;
    }

    public double processOrder(Order order) {
        // --- валидация ---
        for (Validator validator : validators) {
            validator.validate(order);
        }

        // --- расчёт скидки по типу клиента ---
        DiscountStrategy discountStrategy = discountStrategyFactory.getStrategy(order.getCustomerType());
        double discount = discountStrategy.applyDiscount(order);

        // --- расчёт комиссии по способу оплаты ---
        CommissionStrategy commissionStrategy = commissionStrategyFactory.getStrategy(order.getPaymentType());
        double commission = commissionStrategy.applyCommission(order);

        // --- итоговая сумма ---
        double finalAmount = order.getAmount() - discount + commission;

        // --- формирование чека прямо тут ---
        printer.print(order, discount, commission, finalAmount);

        // --- "сохранение" заказа  ---
        repository.save(order);

        return finalAmount;
    }
}

