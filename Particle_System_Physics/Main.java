package Particle_System_Physics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[FX] Spawning Explosion Particles...");
        List<Particle> particles = new ArrayList<>();
        
        // Spawn
        for(int i=0; i<5; i++) particles.add(new Particle());
        
        // Update Loop (1 Tick)
        System.out.println("Updating Physics (Gravity)...");
        for(Particle p : particles) {
            p.update();
            System.out.println("Particle Pos Y: " + p.y + " (Falling)");
        }
    }
}

class Particle {
    double y = 10.0;
    double velocityY = 0;
    double gravity = -0.5;
    
    public void update() {
        velocityY += gravity;
        y += velocityY;
    }
}