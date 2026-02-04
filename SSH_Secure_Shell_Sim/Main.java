package SSH_Secure_Shell_Sim;

public class Main {
    public static void main(String[] args) {
        System.out.println("[SSH] Connecting to root@192.168.1.5...");
        
        // 1. Handshake
        System.out.println("   [1] Server sent Host Key (RSA-2048).");
        System.out.println("   [2] Verifying Host Fingerprint: 3b:4a:21...");
        System.out.println("   [3] Key Exchange (Diffie-Hellman) Complete.");
        
        // 2. Session
        System.out.println("[SSH] Session Established. Channel Encrypted (AES).");
        
        // 3. Command Execution
        executeRemote("ls -la");
        executeRemote("whoami");
    }
    
    static void executeRemote(String cmd) {
        System.out.println("root@host:~# " + cmd);
        if(cmd.equals("whoami")) System.out.println("root");
        else if(cmd.equals("ls -la")) System.out.println("drwxr-xr-x .ssh\n-rw-r--r-- authorized_keys");
    }
}