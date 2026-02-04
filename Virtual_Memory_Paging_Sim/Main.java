package Virtual_Memory_Paging_Sim;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MMU mmu = new MMU();
        
        System.out.println("[CPU] Requesting Address 10...");
        mmu.accessMemory(10);
        
        System.out.println("[CPU] Requesting Address 99 (Not in RAM)...");
        mmu.accessMemory(99);
    }
}

class MMU { // Memory Management Unit
    Set<Integer> ram = new HashSet<>();
    
    public MMU() {
        ram.add(10); // Page 10 is loaded
        ram.add(20);
    }
    
    public void accessMemory(int pageId) {
        if(ram.contains(pageId)) {
            System.out.println("   [HIT] Page " + pageId + " found in RAM.");
        } else {
            System.out.println("   [MISS] Page Fault! Loading Page " + pageId + " from Disk...");
            ram.add(pageId); // Simulate loading
        }
    }
}