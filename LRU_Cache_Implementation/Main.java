package LRU_Cache_Implementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[CACHE] Initializing LRU Cache (Capacity: 2)...");
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, "User-A");
        cache.put(2, "User-B");
        System.out.println("Get 1: " + cache.get(1)); // Access 1, making 2 LRU
        
        cache.put(3, "User-C"); // Evicts 2
        System.out.println("Get 2: " + cache.get(2) + " (Should be null)");
        System.out.println("Get 3: " + cache.get(3));
    }
}

class LRUCache extends LinkedHashMap<Integer, String> {
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > capacity;
    }
}