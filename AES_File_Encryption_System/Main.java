package AES_File_Encryption_System;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("[SECURE] Generating AES Key...");
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey key = keyGen.generateKey();
        
        String content = "This is a confidential document.";
        System.out.println("Original: " + content);
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(content.getBytes());
        
        String encStr = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("Encrypted File Content: " + encStr);
    }
}