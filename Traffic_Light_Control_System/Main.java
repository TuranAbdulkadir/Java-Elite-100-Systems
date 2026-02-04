package Traffic_Light_Control_System;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        
        for(int i=0; i<3; i++) {
            light.changeState();
            Thread.sleep(500);
        }
    }
}

class TrafficLight {
    enum State { RED, GREEN, YELLOW }
    State current = State.RED;
    
    public void changeState() {
        switch(current) {
            case RED: 
                current = State.GREEN; 
                System.out.println("[LIGHT] Turned GREEN (Go)"); 
                break;
            case GREEN: 
                current = State.YELLOW; 
                System.out.println("[LIGHT] Turned YELLOW (Slow)"); 
                break;
            case YELLOW: 
                current = State.RED; 
                System.out.println("[LIGHT] Turned RED (Stop)"); 
                break;
        }
    }
}