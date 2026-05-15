package com.ecommerce.order.state;

import com.ecommerce.order.Order;
import com.ecommerce.order.OrderState;

public class ProcessingState implements OrderState {
    @Override
    public void payOrder(Order order) {
        System.out.println("INFO: Order ini sudah dibayar sebelumnya.");
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Order " + order.getOrderId() + " sedang disiapkan oleh penjual.");
        // Transisi ke state berikutnya
        order.setState(order.getShippedState());
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("GAGAL: Order masih diproses, belum siap dikirim.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("GAGAL: Order belum dikirim.");
    }
}