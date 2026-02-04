package Antivirus_Signature_Scanner;

import java.util.*;

public class Main {
    // Known virus signature (e.g., EICAR test string part)
    static String VIRUS_SIG = "X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*";

    public static void main(String[] args) {
        System.out.println("[AV] Updating Virus Definitions...");
        Set<String> signatures = new HashSet<>();
        signatures.add(VIRUS_SIG);
        
        System.out.println("[AV] Scanning System Memory...");
        
        // Simulated File Content
        String cleanFile = "This is a normal text file.";
        String infectedFile = "System data... " + VIRUS_SIG + " ...corrupted.";
        
        scan(cleanFile, signatures);
        scan(infectedFile, signatures);
    }
    
    static void scan(String content, Set<String> db) {
        for(String sig : db) {
            if(content.contains(sig)) {
                System.out.println("[ALERT] Threat Detected! Signature matched.");
                return;
            }
        }
        System.out.println("[OK] File is clean.");
    }
}