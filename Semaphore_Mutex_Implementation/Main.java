package Semaphore_Mutex_Implementation;

import java.util.concurrent.Semaphore;

public class Main {
    static Semaphore mutex = new Semaphore(1); // Only 1 permit
    
    public static void main(String[] args) {
        new Worker("Thread-A").start();
        new Worker("Thread-B").start();
    }
    
    static class Worker extends Thread {
        public Worker(String name) { super(name); }
        public void run() {
            try {
                System.out.println(getName() + " waiting...");
                mutex.acquire(); // Lock
                System.out.println("   " + getName() + " ENTERED Critical Section");
                Thread.sleep(1000);
                System.out.println("   " + getName() + " LEAVING");
                mutex.release(); // Unlock
            } catch(Exception e){}
        }
    }
}