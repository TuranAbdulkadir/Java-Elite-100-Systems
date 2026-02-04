package Reverse_Proxy_Nginx_Logic;

public class Main {
    public static void main(String[] args) {
        System.out.println("[NGINX] Reverse Proxy Started on :80");
        
        String clientRequest = "GET /index.html";
        String backendServer = "10.0.0.5:8080"; // Hidden Backend
        
        System.out.println("Client connects to Proxy...");
        proxyRequest(clientRequest, backendServer);
    }
    
    static void proxyRequest(String req, String dest) {
        System.out.println("   [PROXY] Forwarding '" + req + "' to Internal Server (" + dest + ")");
        System.out.println("   [BACKEND] Processing...");
        System.out.println("   [PROXY] Sending Response back to Client.");
    }
}