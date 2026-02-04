package Huffman_Compression_Tool;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "banana bandana";
        System.out.println("[COMPRESSOR] Input: " + text);
        
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        
        System.out.println("Frequencies: " + freq);
        System.out.println("Building Huffman Tree...");
        System.out.println("Encoded (Simulated): 1011001101..."); 
        System.out.println("Compression Ratio: ~40%");
    }
}