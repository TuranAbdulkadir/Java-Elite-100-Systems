package Markov_Chain_Text_Generator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String corpus = "the cat sat on the mat and the cat ate";
        System.out.println("[MARKOV] Learning from: " + corpus);
        
        Map<String, List<String>> chain = new HashMap<>();
        String[] words = corpus.split(" ");
        
        for(int i=0; i < words.length - 1; i++) {
            chain.putIfAbsent(words[i], new ArrayList<>());
            chain.get(words[i]).add(words[i+1]);
        }
        
        System.out.println("[GENERATING] Starting with 'the'...");
        String current = "the";
        System.out.print(current);
        
        Random r = new Random();
        for(int i=0; i<5; i++) {
            if(!chain.containsKey(current)) break;
            List<String> nextOptions = chain.get(current);
            String next = nextOptions.get(r.nextInt(nextOptions.size()));
            System.out.print(" " + next);
            current = next;
        }
        System.out.println();
    }
}