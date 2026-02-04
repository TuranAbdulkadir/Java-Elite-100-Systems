package Matrix_Math_Kernel;

public class Main {
    public static void main(String[] args) {
        System.out.println("[KERNEL] Multiplying 2x2 Matrices...");
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{2, 0}, {1, 2}};
        
        // Result should be: {{4, 4}, {10, 8}}
        // Row 1: 1*2 + 2*1 = 4 | 1*0 + 2*2 = 4
        // Row 2: 3*2 + 4*1 = 10| 3*0 + 4*2 = 8
        
        double[][] c = multiply(a, b);
        System.out.println("Result: [" + c[0][0] + ", " + c[0][1] + "]");
        System.out.println("        [" + c[1][0] + ", " + c[1][1] + "]");
    }
    
    static double[][] multiply(double[][] a, double[][] b) {
        int rowsA = a.length, colsA = a[0].length, colsB = b[0].length;
        double[][] result = new double[rowsA][colsB];
        for(int i=0; i<rowsA; i++) {
            for(int k=0; k<colsA; k++) { // Optimized loop order
                for(int j=0; j<colsB; j++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}