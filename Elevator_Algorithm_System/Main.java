package Elevator_Algorithm_System;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Elevator e = new Elevator();
        e.requestFloor(5);
        e.requestFloor(2);
        e.requestFloor(8);
        
        e.run();
    }
}

class Elevator {
    TreeSet<Integer> upQueue = new TreeSet<>();
    int currentFloor = 0;
    
    public void requestFloor(int f) {
        upQueue.add(f);
        System.out.println("[BUTTON] Request for Floor " + f);
    }
    
    public void run() {
        System.out.println("[LIFT] Moving Up...");
        for(int floor : upQueue) {
            System.out.println("   -> Stopping at Floor " + floor);
            currentFloor = floor;
        }
        System.out.println("[LIFT] All requests served.");
    }
}