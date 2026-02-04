package Bloom_Filter_Probabilistic;

import java.util.BitSet;

public class Main {
    public static void main(String[] args) {
        BloomFilter bf = new BloomFilter(100);
        bf.add("user@example.com");
        
        System.out.println("Contains 'user@example.com'? " + bf.check("user@example.com"));
        System.out.println("Contains 'admin@example.com'? " + bf.check("admin@example.com"));
    }
}

class BloomFilter {
    BitSet bits;
    public BloomFilter(int size) { bits = new BitSet(size); }
    
    public void add(String s) {
        bits.set(s.hashCode() % 100);
        bits.set((s.hashCode() * 31) % 100);
    }
    
    public boolean check(String s) {
        return bits.get(s.hashCode() % 100) && bits.get((s.hashCode() * 31) % 100);
    }
}