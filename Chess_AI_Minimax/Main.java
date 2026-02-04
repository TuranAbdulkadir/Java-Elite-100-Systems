package Chess_AI_Minimax;

public class Main {
    public static void main(String[] args) {
        System.out.println("[AI] Calculating Best Move...");
        // Board score: +10 (Advantage)
        int score = minimax(3, true); // Depth 3, Maximizing Player
        System.out.println("Best Evaluated Score: " + score);
    }
    
    // Simplified Minimax
    static int minimax(int depth, boolean isMaximizing) {
        if(depth == 0) return 10; // Static evaluation (Leaf node)
        
        if(isMaximizing) {
            System.out.println("   > Maximizing (My Turn)...");
            return Math.max(minimax(depth-1, false), 5); 
        } else {
            System.out.println("   > Minimizing (Opponent Turn)...");
            return Math.min(minimax(depth-1, true), 5);
        }
    }
}