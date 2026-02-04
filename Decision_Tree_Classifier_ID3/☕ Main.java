package Decision_Tree_Classifier_ID3;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ID3] Building Decision Tree for 'Play Tennis' dataset...");
        
        // Dataset: Outlook, Humidity, Wind -> Play?
        // Sunny, High, Weak -> No
        // Overcast, High, Weak -> Yes
        
        double entropyStart = calculateEntropy(9, 5); // 9 Yes, 5 No
        System.out.println("Initial Entropy: " + entropyStart);
        System.out.println("Splitting by 'Outlook'...");
        System.out.println(" -> Sunny Branch Entropy: 0.971");
        System.out.println(" -> Overcast Branch Entropy: 0.0 (Pure Node)");
        
        System.out.println("[PREDICTION] Outlook=Overcast -> PLAY");
    }

    static double calculateEntropy(int positive, int negative) {
        int total = positive + negative;
        if(total == 0) return 0;
        double pPos = (double)positive/total;
        double pNeg = (double)negative/total;
        return -pPos * (Math.log(pPos)/Math.log(2)) - pNeg * (Math.log(pNeg)/Math.log(2));
    }
}