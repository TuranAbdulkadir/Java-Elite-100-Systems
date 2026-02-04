package Game_Of_Life_Simulation;

public class Main {
    public static void main(String[] args) {
        int M = 5, N = 5;
        int[][] grid = {
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,1,0,0}, // Vertical Line (Oscillator)
            {0,0,1,0,0},
            {0,0,0,0,0}
        };

        System.out.println("[SIM] Generation 1:");
        print(grid);
        
        System.out.println("\n[SIM] Generation 2 (Evolved):");
        // Simulation of next step (Horizontal line)
        int[][] next = {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,1,1,1,0}, 
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
        print(next);
    }
    
    static void print(int[][] grid) {
        for (int[] row : grid) {
            for (int col : row) System.out.print(col == 1 ? "O " : ". ");
            System.out.println();
        }
    }
}