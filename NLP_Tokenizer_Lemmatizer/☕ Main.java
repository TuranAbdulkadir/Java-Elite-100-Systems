
package NLP_Tokenizer_Lemmatizer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "The programmers are coding happily in Java!";
        System.out.println("Original: " + text);
        
        // 1. Tokenization
        String[] tokens = text.toLowerCase().split("\\s+");
        
        // 2. Stop words removal & Stemming
        List<String> clean = new ArrayList<>();
        for(String t : tokens) {
            if(t.equals("the") || t.equals("in")) continue; // Stop words
            if(t.endsWith("ing")) t = t.substring(0, t.length()-3); // Basic Stemming
            if(t.endsWith("s")) t = t.substring(0, t.length()-1);
            clean.add(t);
        }
        
        System.out.println("Processed: " + clean); // [programmer, are, cod, happily, java!]
    }
}