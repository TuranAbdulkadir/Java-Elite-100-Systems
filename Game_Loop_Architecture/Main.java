package Game_Loop_Architecture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("[ENGINE] Starting Game Loop (60 FPS)...");
        
        boolean isRunning = true;
        int frames = 0;
        
        while(frames < 5) { // Simulate 5 frames
            long start = System.currentTimeMillis();
            
            update();
            render();
            
            long elapsed = System.currentTimeMillis() - start;
            long wait = 16 - elapsed; // Target ~16ms per frame (60 FPS)
            
            if(wait > 0) Thread.sleep(wait);
            
            frames++;
            System.out.println("--- Frame " + frames + " Complete ---");
        }
    }
    
    static void update() {
        System.out.println(" > Updating Physics & AI...");
    }
    
    static void render() {
        System.out.println(" > Rendering Graphics...");
    }
}