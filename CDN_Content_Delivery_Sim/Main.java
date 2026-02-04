package CDN_Content_Delivery_Sim;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CDN cdn = new CDN();
        
        System.out.println("User is in TURKEY.");
        System.out.println("Routing to: " + cdn.getNearestServer("TR"));
        
        System.out.println("User is in JAPAN.");
        System.out.println("Routing to: " + cdn.getNearestServer("JP"));
    }
}

class CDN {
    Map<String, String> edgeServers = new HashMap<>();
    
    public CDN() {
        edgeServers.put("US", "New York DataCenter");
        edgeServers.put("EU", "Frankfurt DataCenter"); // TR is close to EU
        edgeServers.put("ASIA", "Tokyo DataCenter"); // JP is here
    }
    
    public String getNearestServer(String countryCode) {
        if(countryCode.equals("TR") || countryCode.equals("DE")) return edgeServers.get("EU");
        if(countryCode.equals("JP") || countryCode.equals("CN")) return edgeServers.get("ASIA");
        return edgeServers.get("US"); // Default
    }
}