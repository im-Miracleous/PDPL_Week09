package com.ecommerce.order;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Membuat Order Baru ===");
        Order myOrder = new Order("ORD-2026-XYZ");

        // Skenario Negatif: Mencoba mengirim barang yang belum dibayar
        System.out.println("\n[Uji Coba Kirim Tanpa Bayar]");
        myOrder.ship();

        // Skenario Positif: Alur normal yang seharusnya
        System.out.println("\n[Alur Pemesanan Normal]");
        myOrder.pay();       // Status pindah ke Processing
        myOrder.pay();       // Mencoba bayar lagi saat sedang processing
        myOrder.process();   // Status pindah ke Shipped
        myOrder.ship();      // Mengecek status pengiriman
        myOrder.deliver();   // Status pindah ke Delivered
        myOrder.process();   // Mencoba memproses ulang pesanan yang sudah selesai
    }
}