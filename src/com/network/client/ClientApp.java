package com.network.client;

import com.network.core.Internet;
import com.network.proxy.CampusProxyInternet;

import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Internet campusNetwork = new CampusProxyInternet();

        System.out.println("=== Sistem Jaringan Kampus ===");
        System.out.println("Gunakan koneksi ini untuk keperluan akademik.");
        System.out.println("Ketik 'keluar' atau 'exit' untuk menutup terminal.");
        System.out.println("----------------------------------------------");

        // Menggunakan perulangan agar input bisa dilakukan berkali-kali
        while (true) {
            System.out.print("\nMasukkan URL situs yang ingin diakses: ");
            String urlInput = scanner.nextLine().trim();

            // Kondisi untuk menghentikan program
            if (urlInput.equalsIgnoreCase("keluar") || urlInput.equalsIgnoreCase("exit")) {
                System.out.println("Menutup koneksi. Terima kasih.");
                break;
            }

            // Validasi input kosong
            if (urlInput.trim().isEmpty()) {
                System.out.println("URL tidak boleh kosong!");
                continue;
            }

            String lowerCaseInput = urlInput.toLowerCase();
            if (!lowerCaseInput.startsWith("http://") && !lowerCaseInput.startsWith("https://")) {
                urlInput = "https://" + urlInput; // Tambahkan https:// di depan
            }

            try {
                // Meminta proxy untuk menghubungkan ke URL yang diinputkan
                campusNetwork.connectTo(urlInput);
            } catch (Exception e) {
                // Menangkap pesan penolakan dari CampusProxyInternet
                System.out.println(e.getMessage());
            }
        }

        // Menutup scanner untuk mencegah memory leak
        scanner.close();
    }
}
