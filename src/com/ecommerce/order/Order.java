package com.ecommerce.order;

import com.ecommerce.order.state.*;

public class Order {
    // Menyimpan instance dari semua state agar tidak perlu membuat objek baru berkali-kali (Memory efficient)
    private final OrderState unpaidState;
    private final OrderState processingState;
    private final OrderState shippedState;
    private final OrderState deliveredState;

    // State saat ini dienkapsulasi
    private OrderState currentState;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;

        // Inisialisasi semua kemungkinan state
        unpaidState = new UnpaidState();
        processingState = new ProcessingState();
        shippedState = new ShippedState();
        deliveredState = new DeliveredState();

        // Default state saat order pertama kali dibuat
        this.currentState = unpaidState;
    }

    // --- Aksi yang didelegasikan ke currentState ---
    public void pay() {
        currentState.payOrder(this);
    }

    public void process() {
        currentState.processOrder(this);
    }

    public void ship() {
        currentState.shipOrder(this);
    }

    public void deliver() {
        currentState.deliverOrder(this);
    }

    // --- Setter untuk mengubah state (Hanya boleh dipanggil oleh Concrete State) ---
    public void setState(OrderState state) {
        this.currentState = state;
    }

    // --- Getter untuk transisi state ---
    public OrderState getUnpaidState() { return unpaidState; }
    public OrderState getProcessingState() { return processingState; }
    public OrderState getShippedState() { return shippedState; }
    public OrderState getDeliveredState() { return deliveredState; }

    public String getOrderId() { return orderId; }
}