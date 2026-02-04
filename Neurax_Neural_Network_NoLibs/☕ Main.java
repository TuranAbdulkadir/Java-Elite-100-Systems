
package Neurax_Neural_Network_NoLibs;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("[NEURAX] Training AI on XOR problem...");
        // 0,0->0 | 0,1->1 | 1,0->1 | 1,1->0
        double[][] inputs = {{0,0}, {0,1}, {1,0}, {1,1}};
        double[][] targets = {{0}, {1}, {1}, {0}};

        SimpleNN nn = new SimpleNN();
        for(int i=0; i<50000; i++) {
            int idx = new Random().nextInt(4);
            nn.train(inputs[idx], targets[idx][0]);
        }

        System.out.println("0, 0 -> " + String.format("%.4f", nn.predict(inputs[0])));
        System.out.println("0, 1 -> " + String.format("%.4f", nn.predict(inputs[1])));
        System.out.println("1, 0 -> " + String.format("%.4f", nn.predict(inputs[2])));
        System.out.println("1, 1 -> " + String.format("%.4f", nn.predict(inputs[3])));
    }
}

class SimpleNN {
    // Simplified 2-2-1 Network for brevity
    double w1 = Math.random(), w2 = Math.random(); // Input weights
    double w3 = Math.random(), w4 = Math.random(); // Hidden weights
    double b1 = Math.random(), b2 = Math.random(); // Biases
    
    public double sigmoid(double x) { return 1 / (1 + Math.exp(-x)); }
    
    public double predict(double[] in) {
        double h1 = sigmoid(in[0] * w1 + in[1] * w2 + b1);
        return sigmoid(h1 * w3 + w4 + b2); // Simplified forward pass
    }
    
    public void train(double[] in, double target) {
        // Mock Backpropagation for demonstration (Full Matrix version is in previous complex example)
        double pred = predict(in);
        double error = target - pred;
        w1 += error * in[0] * 0.1;
        w2 += error * in[1] * 0.1;
    }
}