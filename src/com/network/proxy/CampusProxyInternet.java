package com.network.proxy;

import com.network.core.Internet;
import com.network.core.RealInternet;

import java.util.ArrayList;
import java.util.List;

public class CampusProxyInternet implements Internet {
    private Internet realInternet;
    private static final List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("hypixel.net");
        bannedSites.add("netflix.com");
        bannedSites.add("youtube.com");
    }

    @Override
    public void connectTo(String serverHost) throws Exception {
        String lowerCaseUrl = serverHost.toLowerCase();

        for (String bannedSite : bannedSites) {
            if (lowerCaseUrl.contains(bannedSite)) {
                throw new Exception("❌ Akses Ditolak: URL mengandung domain \"" + bannedSite + "\" yang diblokir kampus.");
            }
        }

        if (realInternet == null) {
            realInternet = new RealInternet();
        }

        realInternet.connectTo(serverHost);
    }
}
