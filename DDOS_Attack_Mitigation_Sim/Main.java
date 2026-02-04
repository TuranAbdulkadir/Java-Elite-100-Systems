package DDOS_Attack_Mitigation_Sim;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Firewall fw = new Firewall();
        
        System.out.println("[DDOS] Attack Started from 192.168.1.50...");
        for(int i=0; i<15; i++) {
            fw.checkRequest("192.168.1.50");
        }
        
        System.out.println("\n[TRAFFIC] Normal user 10.0.0.1...");
        fw.checkRequest("10.0.0.1");
    }
}

class Firewall {
    Map<String, Integer> traffic = new HashMap<>();
    Set<String> blacklist = new HashSet<>();
    
    public void checkRequest(String ip) {
        if(blacklist.contains(ip)) {
            System.out.println("   [BLOCK] Request from " + ip + " dropped.");
            return;
        }
        
        traffic.put(ip, traffic.getOrDefault(ip, 0) + 1);
        if(traffic.get(ip) > 10) {
            blacklist.add(ip);
            System.out.println("!!! [ALERT] " + ip + " added to BLACKLIST (DDoS Detected) !!!");
        } else {
            System.out.println("   [ALLOW] Request from " + ip + " passed.");
        }
    }
}