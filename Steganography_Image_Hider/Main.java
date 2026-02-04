package Steganography_Image_Hider;

public class Main {
    public static void main(String[] args) {
        System.out.println("[STEGO] Hiding message in pixel...");
        
        int pixel = 0xFF0000; // Red Color (11111111 00000000 00000000)
        int secretBit = 1;
        
        System.out.println("Original Pixel: " + Integer.toBinaryString(pixel));
        
        // Clear last bit and OR with secret
        int newPixel = (pixel & 0xFFFFFFFE) | secretBit;
        
        System.out.println("Modified Pixel: " + Integer.toBinaryString(newPixel));
        System.out.println("Difference is invisible to human eye.");
    }
}