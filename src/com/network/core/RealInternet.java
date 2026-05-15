package com.network.core;

public class RealInternet implements Internet {
    public RealInternet() {
        System.out.println("-> [Sistem] Mengaktifkan koneksi ISP utama... Selesai.");
    }

    @Override
    public void connectTo(String serverHost) {
        System.out.println("\uD83C\uDF10 Berhasil terhubung ke: " + serverHost);
    }
}
