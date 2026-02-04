package Deadlock_Detection_Bankers_Algo;

public class Main {
    public static void main(String[] args) {
        System.out.println("[BANKER] Checking System State...");
        
        int available = 3; // 3 Resources free
        int need = 4;      // Process needs 4
        
        if(need <= available) {
            System.out.println("   [SAFE] Granting resources.");
        } else {
            System.out.println("   [UNSAFE] Denied! Potential Deadlock.");
        }
    }
}