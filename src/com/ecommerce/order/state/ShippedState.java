package com.ecommerce.order.state;

import com.ecommerce.order.Order;
import com.ecommerce.order.OrderState;

public class ShippedState implements OrderState {
    @Override
    public void payOrder(Order order) {
        System.out.println("INFO: Order ini sudah dibayar.");
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("INFO: Order sudah selesai diproses dan sedang dalam perjalanan.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("INFO: Order sedang dalam perjalanan menuju alamat tujuan.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Paket untuk order " + order.getOrderId() + " telah diterima oleh pelanggan.");
        // Transisi ke state akhir
        order.setState(order.getDeliveredState());
    }
}