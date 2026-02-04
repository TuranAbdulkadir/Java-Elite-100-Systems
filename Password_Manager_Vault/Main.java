package Password_Manager_Vault;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("[VAULT] Setting up Master Password...");
        char[] password = "my_super_secret_pass".toCharArray();
        byte[] salt = new byte[16]; // Should be random in production
        
        byte[] hash = hashPassword(password, salt);
        System.out.println("Stored Hash (PBKDF2): " + Arrays.toString(hash));
        
        System.out.println("[LOGIN] Verifying password...");
        boolean match = validate(password, salt, hash);
        System.out.println("Access Granted? " + match);
    }
    
    static byte[] hashPassword(char[] pass, byte[] salt) throws Exception {
        KeySpec spec = new PBEKeySpec(pass, salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return f.generateSecret(spec).getEncoded();
    }
    
    static boolean validate(char[] pass, byte[] salt, byte[] expected) throws Exception {
        byte[] actual = hashPassword(pass, salt);
        return Arrays.equals(actual, expected);
    }
}