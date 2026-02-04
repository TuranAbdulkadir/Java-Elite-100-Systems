package Consistent_Hashing_Ring;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ConsistentHash ring = new ConsistentHash();
        
        ring.addNode("Server-A");
        ring.addNode("Server-B");
        ring.addNode("Server-C");
        
        System.out.println("[RING] locating servers for users...");
        System.out.println("User-101 -> " + ring.getNode("User-101"));
        System.out.println("User-202 -> " + ring.getNode("User-202"));
        
        System.out.println("[EVENT] Server-A crashed!");
        ring.removeNode("Server-A");
        
        System.out.println("User-101 -> " + ring.getNode("User-101") + " (Re-routed automatically)");
    }
}

class ConsistentHash {
    private TreeMap<Integer, String> circle = new TreeMap<>();
    
    public void addNode(String node) {
        circle.put(node.hashCode(), node);
    }
    
    public void removeNode(String node) {
        circle.remove(node.hashCode());
    }
    
    public String getNode(String key) {
        if(circle.isEmpty()) return null;
        int hash = key.hashCode();
        if(!circle.containsKey(hash)) {
            // Halka mantığı: Hash değerinden büyük en küçük anahtarı bul
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}