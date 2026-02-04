package Quantum_Encryption_Core;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("[CORE] Initializing Quantum Secure Tunnel...");
        
        // 1. Generate RSA Keys (Identity)
        KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
        rsaGen.initialize(2048);
        KeyPair pair = rsaGen.generateKeyPair();
        
        // 2. Generate AES Key (Session)
        KeyGenerator aesGen = KeyGenerator.getInstance("AES");
        aesGen.init(256);
        SecretKey aesKey = aesGen.generateKey();

        // 3. Encrypt Data
        String secret = "NUCLEAR_LAUNCH_CODE: 9942-alpha";
        Cipher aesCipher = Cipher.getInstance("AES/GCM/NoPadding");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, new GCMParameterSpec(128, new byte[12]));
        byte[] encrypted = aesCipher.doFinal(secret.getBytes());
        
        System.out.println("Original: " + secret);
        System.out.println("Encrypted (AES-GCM): " + Base64.getEncoder().encodeToString(encrypted));
        
        // 4. Encrypt AES Key with RSA
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        byte[] encryptedKey = rsaCipher.doFinal(aesKey.getEncoded());
        
        System.out.println("Session Key Encrypted (RSA): " + Base64.getEncoder().encodeToString(encryptedKey));
    }
}