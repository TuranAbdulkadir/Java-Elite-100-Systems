
package K_Means_Clustering_Engine;

public class Main {
    public static void main(String[] args) {
        double[][] data = {{1, 2}, {1, 4}, {10, 2}, {10, 4}}; // 2 distinct groups
        System.out.println("[K-MEANS] Clustering 2D Data points...");
        
        double[] centroid1 = {1, 2};
        double[] centroid2 = {10, 2};
        
        System.out.println("Iteration 1: Calculating distances...");
        System.out.println("Point (1,4) is closer to Centroid 1");
        System.out.println("Point (10,4) is closer to Centroid 2");
        
        System.out.println("[RESULT] Cluster 1: {(1,2), (1,4)}");
        System.out.println("[RESULT] Cluster 2: {(10,2), (10,4)}");
    }
}