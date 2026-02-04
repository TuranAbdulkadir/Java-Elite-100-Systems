package Jarvis_System_Core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   J.A.R.V.I.S - SYSTEM CORE ONLINE");
        System.out.println("   Elite 100 System Architecture Ready.");
        System.out.println("=========================================");
        
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.print("COMMAND > ");
            String input = sc.nextLine().toLowerCase();
            
            if(input.equals("exit")) {
                System.out.println("[JARVIS] Shutting down. Goodbye, Sir.");
                break;
            }
            
            processCommand(input);
        }
    }
    
    static void processCommand(String cmd) {
        switch(cmd) {
            case "scan network":
                System.out.println("[MODULE 91] Scanning local network...");
                System.out.println("   > 192.168.1.1 (Router)");
                System.out.println("   > 192.168.1.15 (Target)");
                break;
            case "encrypt data":
                System.out.println("[MODULE 01] Engaging Quantum Encryption...");
                System.out.println("   > Data Locked (AES-256).");
                break;
            case "status":
                System.out.println("[SYSTEM] CPU: 12% | RAM: 4GB/16GB | Network: Secure");
                break;
            case "help":
                System.out.println("Available: 'scan network', 'encrypt data', 'status', 'exit'");
                break;
            default:
                System.out.println("[JARVIS] Command not recognized.");
        }
    }
}