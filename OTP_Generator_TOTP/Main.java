package OTP_Generator_TOTP;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        System.out.println("[2FA] Generating Code...");
        
        long timeIndex = Instant.now().getEpochSecond() / 30;
        String secret = "JBSWY3DPEHPK3PXP"; // Base32 Secret
        
        // Simulated HMAC Logic
        int hash = (int)(timeIndex ^ secret.hashCode());
        int otp = Math.abs(hash % 1000000);
        
        System.out.println("Your Code: " + String.format("%06d", otp));
        System.out.println("(Expires in 30 seconds)");
    }
}