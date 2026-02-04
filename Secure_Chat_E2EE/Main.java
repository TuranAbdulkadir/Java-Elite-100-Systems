package Secure_Chat_E2EE;

public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        
        System.out.println("[CHAT] Performing Handshake...");
        // Simulation of Diffie-Hellman Key Exchange
        int sharedSecret = 999; 
        
        System.out.println("[ALICE] Sending: 'Hello Bob'");
        String encrypted = alice.encrypt("Hello Bob", sharedSecret);
        System.out.println("[NETWORK] Carrying: " + encrypted);
        
        String decrypted = bob.decrypt(encrypted, sharedSecret);
        System.out.println("[BOB] Received: " + decrypted);
    }
}

class User {
    String name;
    public User(String n) { name = n; }
    
    public String encrypt(String msg, int key) {
        return "ENC(" + msg + ")"; // Mock Encryption
    }
    
    public String decrypt(String blob, int key) {
        return blob.replace("ENC(", "").replace(")", "");
    }
}