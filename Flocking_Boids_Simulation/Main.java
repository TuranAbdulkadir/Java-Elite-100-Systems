package Flocking_Boids_Simulation;

public class Main {
    public static void main(String[] args) {
        System.out.println("[BOIDS] Simulating Flock Behavior...");
        
        Boid b1 = new Boid(10, 10);
        Boid b2 = new Boid(12, 12); // Nearby neighbor
        
        System.out.println("Boid-1 Position: " + b1.x + ", " + b1.y);
        System.out.println("Calculating Cohesion Vector...");
        
        // Cohesion logic simulation: Move towards neighbor
        double targetX = b2.x;
        double targetY = b2.y;
        
        System.out.println("Steering towards: " + targetX + ", " + targetY);
    }
}

class Boid {
    double x, y;
    public Boid(double x, double y) { this.x = x; this.y = y; }
}