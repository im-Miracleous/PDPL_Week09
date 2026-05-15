package com.ecommerce.order.state;

import com.ecommerce.order.Order;
import com.ecommerce.order.OrderState;

public class DeliveredState implements OrderState {
    @Override
    public void payOrder(Order order) {
        System.out.println("INFO: Order sudah selesai, tidak perlu bayar lagi.");
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("INFO: Order sudah selesai.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("INFO: Order sudah sampai tujuan.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("INFO: Paket sudah dikonfirmasi diterima sebelumnya.");
    }
}