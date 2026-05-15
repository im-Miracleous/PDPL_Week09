package com.ecommerce.order.state;

import com.ecommerce.order.Order;
import com.ecommerce.order.OrderState;

public class UnpaidState implements OrderState {
    @Override
    public void payOrder(Order order) {
        System.out.println("Pembayaran untuk order " + order.getOrderId() + " berhasil diterima.");
        // Transisi ke state berikutnya
        order.setState(order.getProcessingState());
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("GAGAL: Order belum dibayar, tidak bisa diproses.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("GAGAL: Order belum dibayar, tidak bisa dikirim.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("GAGAL: Order belum dibayar, tidak bisa diserahkan.");
    }
}