package OS_Kernel_Scheduler_Sim;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scheduler os = new Scheduler(2); // 2ms Time Quantum
        
        os.addProcess(new Process("Chrome", 5));
        os.addProcess(new Process("VS Code", 3));
        os.addProcess(new Process("Spotify", 6));
        
        os.run();
    }
}

class Scheduler {
    Queue<Process> queue = new LinkedList<>();
    int quantum;
    
    public Scheduler(int q) { quantum = q; }
    public void addProcess(Process p) { queue.add(p); }
    
    public void run() {
        System.out.println("[KERNEL] Starting Round Robin Scheduler (Q=" + quantum + ")...");
        while(!queue.isEmpty()) {
            Process p = queue.poll();
            System.out.println("   > Executing: " + p.name + " (Remaining: " + p.burstTime + ")");
            
            if(p.burstTime > quantum) {
                p.burstTime -= quantum;
                queue.add(p); // Back to queue
            } else {
                System.out.println("   > [FINISHED] " + p.name);
            }
        }
    }
}

class Process {
    String name; int burstTime;
    public Process(String n, int b) { name=n; burstTime=b; }
}