package Compiler_Lexical_Analyzer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String code = "int x = 10 + 20;";
        System.out.println("[LEXER] Analyzing: " + code);
        
        List<String> tokens = tokenize(code);
        for(String t : tokens) {
            System.out.println("   Token: " + t);
        }
    }
    
    static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, " =+;", true);
        while(st.hasMoreTokens()) {
            String t = st.nextToken().trim();
            if(!t.isEmpty()) tokens.add(identify(t));
        }
        return tokens;
    }
    
    static String identify(String t) {
        if(t.equals("int")) return "[KEYWORD: int]";
        if(t.matches("\\d+")) return "[NUMBER: " + t + "]";
        if(t.matches("[a-zA-Z]+")) return "[ID: " + t + "]";
        return "[OP: " + t + "]";
    }
}