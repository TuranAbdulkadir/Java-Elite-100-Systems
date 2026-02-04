package API_Gateway_Router;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Gateway gateway = new Gateway();
        
        // Define Routes
        gateway.addRoute("/users", "User-Service:8081");
        gateway.addRoute("/orders", "Order-Service:8082");
        
        System.out.println("[GATEWAY] Incoming Request: GET /users/123");
        gateway.handleRequest("/users/123");
        
        System.out.println("[GATEWAY] Incoming Request: GET /products/99");
        gateway.handleRequest("/products/99");
    }
}

class Gateway {
    Map<String, String> routes = new HashMap<>();
    
    public void addRoute(String path, String service) {
        routes.put(path, service);
    }
    
    public void handleRequest(String url) {
        for(String key : routes.keySet()) {
            if(url.startsWith(key)) {
                System.out.println("   -> Routing to: " + routes.get(key));
                return;
            }
        }
        System.out.println("   -> [404] No Route Matched.");
    }
}