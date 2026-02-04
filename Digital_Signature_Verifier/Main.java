package Digital_Signature_Verifier;

import java.security.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Setup Keys
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair pair = kpg.generateKeyPair();
        
        String data = "Pay $500 to Alice";
        
        // 2. Sign Data (Sender)
        Signature signEngine = Signature.getInstance("SHA256withRSA");
        signEngine.initSign(pair.getPrivate());
        signEngine.update(data.getBytes());
        byte[] signature = signEngine.sign();
        
        System.out.println("Data: " + data);
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature).substring(0, 50) + "...");
        
        // 3. Verify Data (Receiver)
        Signature verifyEngine = Signature.getInstance("SHA256withRSA");
        verifyEngine.initVerify(pair.getPublic());
        verifyEngine.update(data.getBytes());
        
        boolean isCorrect = verifyEngine.verify(signature);
        System.out.println("Signature Valid? " + isCorrect);
    }
}