package JWT_Token_Manager;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String payload = "{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"admin\":true}";
        String secret = "my_secret_key";
        
        System.out.println("[JWT] Generating Token...");
        String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(header.getBytes());
        String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes());
        
        String signatureInput = encodedHeader + "." + encodedPayload;
        String signature = "mock_signature_hash"; // Simplified
        
        String jwt = signatureInput + "." + signature;
        System.out.println("Token: " + jwt);
    }
}