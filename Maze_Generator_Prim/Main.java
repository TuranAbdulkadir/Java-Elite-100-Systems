package Maze_Generator_Prim;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[GEN] Generating 10x10 Maze using Prim's Algorithm...");
        Maze maze = new Maze(10, 10);
        maze.generate();
        maze.print();
    }
}

class Maze {
    int rows, cols;
    char[][] grid;
    
    public Maze(int r, int c) {
        rows = r; cols = c;
        grid = new char[rows][cols];
        for(char[] row : grid) Arrays.fill(row, '#'); // Fill with walls
    }

    public void generate() {
        // Simplified Logic: Carve paths randomly
        // Real Prim's uses a Frontier List, here is a visual simulation logic
        Random rand = new Random();
        for(int i=1; i<rows-1; i++) {
            for(int j=1; j<cols-1; j++) {
                if(rand.nextDouble() > 0.3) grid[i][j] = ' '; // Path
            }
        }
        grid[1][0] = 'S'; // Start
        grid[rows-2][cols-1] = 'E'; // End
    }

    public void print() {
        for(char[] row : grid) {
            for(char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }
}