package Image_Convolution_Filter;

public class Main {
    public static void main(String[] args) {
        System.out.println("[VISION] Applying Sharpen Kernel...");
        
        // Mock 3x3 Image Pixel Data (Grayscale)
        int[][] image = {
            {10, 10, 10},
            {10, 50, 10},
            {10, 10, 10}
        };
        
        // Sharpen Kernel
        int[][] kernel = {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
        };
        
        System.out.println("Original Center Pixel: " + image[1][1]);
        
        // Convolve center pixel (1,1)
        int sum = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                sum += image[i][j] * kernel[i][j];
            }
        }
        
        System.out.println("New Pixel Value: " + sum + " (Sharpened)");
    }
}