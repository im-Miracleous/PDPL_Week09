package com.ecommerce.order;

public interface OrderState {
    void payOrder(Order order);
    void processOrder(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
}