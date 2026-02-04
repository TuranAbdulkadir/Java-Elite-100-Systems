package Load_Balancer_Round_Robin;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer(List.of("Server-A (US)", "Server-B (EU)", "Server-C (ASIA)"));
        
        // Simulate 10 concurrent requests
        for(int i=0; i<10; i++) {
            String server = lb.getServer();
            System.out.println("Request ID: " + i + " -> Routed to: " + server);
        }
    }
}

class LoadBalancer {
    private List<String> servers;
    private AtomicInteger counter = new AtomicInteger(0);

    public LoadBalancer(List<String> servers) { this.servers = servers; }

    public String getServer() {
        int index = counter.getAndIncrement() % servers.size();
        return servers.get(index);
    }
}