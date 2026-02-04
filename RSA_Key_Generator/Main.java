package RSA_Key_Generator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("[CRYPTO] Generating RSA-2048 Key Pair...");
        
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        
        String pub = Base64.getEncoder().encodeToString(kp.getPublic().getEncoded());
        String priv = Base64.getEncoder().encodeToString(kp.getPrivate().getEncoded());
        
        System.out.println("\n--- Public Key (Share this) ---");
        System.out.println(pub.substring(0, 100) + "...");
        
        System.out.println("\n--- Private Key (KEEP SECRET) ---");
        System.out.println(priv.substring(0, 100) + "...");
    }
}