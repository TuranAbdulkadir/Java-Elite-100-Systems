package Procedural_Terrain_Generation;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("[TERRAIN] Generating 5x5 Heightmap...");
        
        // Simulating Smooth Noise
        int[][] map = new int[5][5];
        Random r = new Random();
        
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                // In real Perlin, this uses neighbors. Here we mock smooth steps.
                map[i][j] = r.nextInt(3) + 5; 
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}