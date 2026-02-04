package Genetic_Algorithm_Evolver;

import java.util.Random;

public class Main {
    static final String TARGET = "HELLO WORLD";
    static final String GENES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    static Random r = new Random();

    public static void main(String[] args) {
        String parent = generateRandom(TARGET.length());
        int generation = 0;

        while(!parent.equals(TARGET)) {
            String child = mutate(parent);
            if(fitness(child) > fitness(parent)) {
                parent = child;
            }
            System.out.println("Gen " + generation + ": " + parent + " | Fitness: " + fitness(parent));
            generation++;
        }
    }

    static String generateRandom(int len) {
        char[] res = new char[len];
        for(int i=0; i<len; i++) res[i] = GENES.charAt(r.nextInt(GENES.length()));
        return new String(res);
    }

    static String mutate(String p) {
        char[] ch = p.toCharArray();
        ch[r.nextInt(p.length())] = GENES.charAt(r.nextInt(GENES.length()));
        return new String(ch);
    }

    static int fitness(String attempt) {
        int score = 0;
        for(int i=0; i<TARGET.length(); i++) {
            if(attempt.charAt(i) == TARGET.charAt(i)) score++;
        }
        return score;
    }
}