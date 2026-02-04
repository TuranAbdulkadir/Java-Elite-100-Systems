package Keylogger_Hook_Sim;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[HOOK] Keylogger active. Listening to keystrokes...");
        
        // Simulated User Typing
        String userTyping = "Hello World! password123";
        List<Character> logBuffer = new ArrayList<>();
        
        for(char c : userTyping.toCharArray()) {
            // Intercepting
            logBuffer.add(c);
            System.out.print("*"); // Silent capture
        }
        
        System.out.println("\n[ATTACKER] Captured Data: " + logBuffer.toString().replaceAll(", ", ""));
        System.out.println("[ALERT] Sensitive data 'password123' found in logs!");
    }
}