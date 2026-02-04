package Physics_Engine_Collision_2D;

public class Main {
    public static void main(String[] args) {
        Box player = new Box(0, 0, 10, 10);
        Box wall = new Box(8, 2, 10, 10); // Overlapping
        
        System.out.println("[PHYSICS] Checking Collision...");
        System.out.println("Player: " + player);
        System.out.println("Wall: " + wall);
        
        if(checkCollision(player, wall)) {
            System.out.println("[ALERT] Collision Detected!");
            resolveCollision(player);
        } else {
            System.out.println("No Collision.");
        }
    }

    static boolean checkCollision(Box a, Box b) {
        return (a.x < b.x + b.w && a.x + a.w > b.x &&
                a.y < b.y + b.h && a.y + a.h > b.y);
    }
    
    static void resolveCollision(Box p) {
        System.out.println("Resolving... Stopping Player movement.");
        // Simple logic: Stop velocity
    }
}

class Box {
    int x, y, w, h;
    public Box(int x, int y, int w, int h) {
        this.x = x; this.y = y; this.w = w; this.h = h;
    }
    public String toString() { return "[x=" + x + ", y=" + y + "]"; }
}