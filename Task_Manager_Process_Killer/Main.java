package Task_Manager_Process_Killer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.list();
        
        System.out.println("\n[ADMIN] Attempting to kill PID 4004...");
        tm.kill(4004);
        
        tm.list();
    }
}

class TaskManager {
    Map<Integer, String> procs = new HashMap<>();
    
    public TaskManager() {
        procs.put(1020, "System");
        procs.put(3301, "Chrome.exe");
        procs.put(4004, "Notepad_Frozen.exe");
    }
    
    public void list() {
        System.out.println("PID\tNAME");
        for(var entry : procs.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
    
    public void kill(int pid) {
        if(procs.containsKey(pid)) {
            String name = procs.remove(pid);
            System.out.println("   [SUCCESS] Terminated process: " + name);
        } else {
            System.out.println("   [ERROR] PID not found.");
        }
    }
}