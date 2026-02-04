package Service_Discovery_Registry;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ServiceRegistry registry = new ServiceRegistry();
        
        System.out.println("[EUREKA] Starting Service Registry...");
        registry.register("Order-Service", "192.168.1.10:8080");
        registry.register("Payment-Service", "192.168.1.20:5000");
        
        System.out.println("Looking up 'Order-Service'...");
        System.out.println("Address: " + registry.discover("Order-Service"));
        
        System.out.println("Looking up 'Unknown-Service'...");
        System.out.println("Address: " + registry.discover("Unknown-Service"));
    }
}

class ServiceRegistry {
    private Map<String, String> services = new HashMap<>();
    
    public void register(String name, String address) {
        services.put(name, address);
        System.out.println("   [REGISTERED] " + name + " @ " + address);
    }
    
    public String discover(String name) {
        return services.getOrDefault(name, "Not Found");
    }
}