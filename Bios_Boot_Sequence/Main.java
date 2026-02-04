package Bios_Boot_Sequence;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("BIOS v2.4 (c) 2024 Inc.");
        
        step("Checking CPU Registers", "OK");
        step("Testing Main Memory (16GB)", "OK");
        step("Detecting Primary Master", "SSD 1TB");
        step("Detecting Input Devices", "Keyboard Detected");
        
        System.out.println("\nAll Hardware OK.");
        System.out.println("Booting from Disk...");
        Thread.sleep(1000);
        System.out.println("[KERNEL] Loading OS...");
    }
    
    static void step(String task, String res) throws InterruptedException {
        System.out.print(task + "... ");
        Thread.sleep(300);
        System.out.println(res);
    }
}