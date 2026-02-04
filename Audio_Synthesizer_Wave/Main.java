package Audio_Synthesizer_Wave;

public class Main {
    public static void main(String[] args) {
        System.out.println("[SYNTH] Generating 440Hz Sine Wave (1 sec)...");
        
        int sampleRate = 44100;
        int durationSeconds = 1;
        double frequency = 440.0;
        
        // Digital Audio Buffer
        double[] buffer = new double[sampleRate * durationSeconds];
        
        for(int i=0; i<buffer.length; i++) {
            // Formula: sin(2 * PI * freq * time)
            double time = (double)i / sampleRate;
            buffer[i] = Math.sin(2 * Math.PI * frequency * time);
            
            if(i < 10) { // Print first 10 samples
                System.out.println("Sample " + i + ": " + String.format("%.4f", buffer[i]));
            }
        }
        System.out.println("... Audio Data Generated.");
    }
}